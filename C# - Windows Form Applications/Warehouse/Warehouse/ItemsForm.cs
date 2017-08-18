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
    public partial class ItemsForm : Form
    {
        //Конструктор на формата
        public ItemsForm()
        {
            InitializeComponent();

            //При създаване на формата се прочита съдържанието на файловете
            Model.ReadData();
            //Създава се списък (BindingList), който свързва информацията от списъка Model.ItemsList с информацията, която се изобразява в data grid-a
            BindingList<Item> ItemsBindinList = new BindingList<Item>(Model.ItemsList);
            //Указва се, че data grid-a ще използва данните от създадения свързващ списък
            dataGridView1.DataSource = ItemsBindinList;
        }

        //Метод, който се извиква при натикане на бутон "Назад"
        private void Back_Click(object sender, EventArgs e)
        {
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
                e.RowIndex >= 0 && e.RowIndex < dataGridView1.RowCount-1)
            {
                //Изтрива се редът от data grid-a. Тъй като grid-а е свързан със списъка Model.ItemsList, редът се изтрива и от Model.ItemsList 
                dataGridView1.Rows.Remove(dataGridView1.Rows[e.RowIndex]);
            }
        }

        //Метод за валидация на съдържанието на клетка от data grid-a. Извиква се когато потребителят кликне някъде ИЗВЪН ВЕЧЕ СЕЛЕКТИРАНА клетка
        private void dataGridView1_CellValidating(object sender, DataGridViewCellValidatingEventArgs e)
        {
            //Извлича се стойността на клетката ПРЕДИ тя да е била селектирана
            String CellOldValue = dataGridView1.Rows[e.RowIndex].Cells[e.ColumnIndex].FormattedValue.ToString();
            //Извлича се стойността на клетката СЛЕД потребителят кликне някъде извън нея
            String CellNewValue = e.FormattedValue.ToString();
            //Ако двете сойностти са еднакви, то потребителя не е извършил промяна и няма нужда да се валидира
            if (CellOldValue.Equals(CellNewValue)) return;

            //Проверка дали се валидира клетка от колона "Име на продукт"
            if (e.ColumnIndex == 2)
            {
                //Ако не е въведено име на продукт, се записва съобщение за грешка
                if (string.IsNullOrEmpty(CellNewValue))
                {
                    dataGridView1.Rows[e.RowIndex].ErrorText = "Въведете име на продукт";
                    //НЕ се позовлява на потребителя да напусне клетката
                    e.Cancel = true;
                }
            }
            //Проверка дали се валидира клетка от колона "Цена на продукт"
            else if (e.ColumnIndex == 3)
            {
                double o;
                //Ако не е въведена цена на продукт, се записва съобщение за грешка
                if (string.IsNullOrEmpty(CellNewValue))
                {
                    dataGridView1.Rows[e.RowIndex].ErrorText = "Въведете цена на продукт";
                    //НЕ се позовлява на потребителя да напусне клетката
                    e.Cancel = true;
                }
                //Ако въведената цена на продукт НЕ е валидно реално число, се записва съобщение за грешка
                else if (!Double.TryParse(CellNewValue, out o))
                {
                    dataGridView1.Rows[e.RowIndex].ErrorText = "Цената на продукта трябва да е реално число";
                    //НЕ се позовлява на потребителя да напусне клетката
                    e.Cancel = true;
                }
            }
            //Проверка дали се валидира клетка от колона "Доставчик"
            else if (e.ColumnIndex == 4)
            {
                int o;
                //Ако не е въведено ID на доставчик, се записва съобщение за грешка
                if (string.IsNullOrEmpty(CellNewValue))
                {
                    dataGridView1.Rows[e.RowIndex].ErrorText = "Въведете ID на доставчик";
                    //НЕ се позовлява на потребителя да напусне клетката
                    e.Cancel = true;
                }
                //Ако въведеното ID на доставчик НЕ е валидно цяло число, се записва съобщение за грешка
                else if (!Int32.TryParse(CellNewValue, out o))
                {
                    dataGridView1.Rows[e.RowIndex].ErrorText = "ID на доставчик трябва да е цяло число";
                    //НЕ се позовлява на потребителя да напусне клетката
                    e.Cancel = true;
                   
                }
            }
        }

        //Метод, който се вика при затваряне на формата
        private void ItemsForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            //Всички данни за продукти и доставчици се запазва във файловете
            Model.StoreData();
        }
    }
}
