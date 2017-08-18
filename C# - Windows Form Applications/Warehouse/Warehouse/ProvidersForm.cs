using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Warehouse
{
    public partial class ProvidersForm : Form
    {
        //ProvidersList - списък с доставчици, който да се свърже с data grid-a
        List<Provider> ProvidersList;

        //Конструктор на формата
        public ProvidersForm()
        {
            InitializeComponent();

            //При създаване на формата се прочита съдържанието на файловете
            Model.ReadData();
            //Списъкът ProvidersList се попълва със стойностите на речника Model.ProvidersDictionary
            ProvidersList = Model.ProvidersDictionary.Values.ToList<Provider>();
            //Създава се списък (BindingList), който свързва информацията от списъка ProvidersList с информацията, която се изобразява в data grid-a
            BindingList<Provider> ProvidersBindingList = new BindingList<Provider>(ProvidersList);
            //Указва се, че data grid-a ще използва данните от създадения свързващ списък
            dataGridView1.DataSource = ProvidersBindingList;
        }

        //Метод, който се извиква при натикане на бутон "Назад"
        private void Back_Click(object sender, EventArgs e)
        {
            //Обхождат се всички доставчици в списъка ProvidersList, който е свързан с data grid-a
            foreach (Provider p in ProvidersList)
            {
                //Ако в списъка ProvidersList съществува доставчик, който НЕ съществува в речника Model.ProvidersDictionary,
                //този доставчик се добавя в речника Model.ProvidersDictionary. Това се прави, тъй като data grid-a на практика не се свързва
                //директно с речника и при добавяне на нови редове в grid-a, не се добавят нови записи в речника автоматично.
                if(!Model.ProvidersDictionary.ContainsKey(p.ID))
                {
                    Model.ProvidersDictionary.Add(p.ID, p);
                }
            }
            //Всички данни за продукти и доставчици се запазва във файловете
            Model.StoreData();
            //Формата се затваря. Освобождават се заетите ресурси
            this.Close();
        }

        //Метод, който се извиква при натискане с мишката върху клетка от data grid-a
        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            var senderGrid = (DataGridView)sender;

            //Проверка дали потребителя е натиснал бутон "Изтрии", който се намира в последната колона на data grid-a
            if (senderGrid.Columns[e.ColumnIndex] is DataGridViewButtonColumn &&
                e.RowIndex >= 0 && e.RowIndex < dataGridView1.RowCount - 1)
            {
                //Извлича се ID на дистрибутор, който трябва да се изтрие
                int id = Int32.Parse(dataGridView1.Rows[e.RowIndex].Cells[1].FormattedValue.ToString());
                //Ако потребителя се опитва да изтрие доставчик 'Неизвестен', се изобразява прозорец за грешка
                //Изтриването не доставчик 'Неизвестен' не е позволено, тъй като при създаване на нов продукт, се указва, че продуктът е доставен от 'Неизвестен' доставчик
                if(id == 0)
                {
                    MessageBox.Show("Доставчик 'Неизвестен' не може да бъде изтрит");
                    return;
                }
                //Обхождат се всички продукти в списъка Model.ItemsList
                foreach (Item i in Model.ItemsList)
                {
                    //Ако в списъка съществува продукт, който да е доставен от доставчика, който трябва да се изтрие, се изобразява прозорец за грешка
                    //Не е позволено да се изтриват доставчици, чийто продукти са все още в склада
                    if (i.Provider.Contains(id.ToString()))
                    {
                        MessageBox.Show("Доставчик " + i.Provider + " не може да бъде изтрит, тъй като в склада са налични продукти, доставени от него");
                        return;
                    }
                }
                //Изтрива се редът от data grid-a. 
                dataGridView1.Rows.Remove(dataGridView1.Rows[e.RowIndex]);
                //Изтрива се записа от речника с всички доставчици
                Model.ProvidersDictionary.Remove(id);
            }
        }

        //Метод за валидация на съдържанието на клетка от data grid-a. Извиква се когато потребителят кликне някъде ИЗВЪН ВЕЧЕ СЕЛЕКТИРАНА клетка
        private void dataGridView1_CellValidating(object sender, DataGridViewCellValidatingEventArgs e)
        {
            //Проверка дали се валидира клетка от колона "Име на доставчик"
            //Ако не е въведено име на продукт, се записва съобщение за грешка
            if (e.ColumnIndex == 2 && string.IsNullOrEmpty(e.FormattedValue.ToString()))
            {
                dataGridView1.Rows[e.RowIndex].ErrorText = "Въведете име на доставчик";
                //НЕ се позовлява на потребителя да напусне клетката
                e.Cancel = true;
            }
        }

        //Метод, който се вика при затваряне на формата
        private void ProvidersForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            //Всички данни за продукти и доставчици се запазва във файловете
            Model.StoreData();
        }
    }
}
