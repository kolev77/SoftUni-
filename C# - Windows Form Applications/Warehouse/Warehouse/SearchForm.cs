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
    public partial class SearchForm : Form
    {
        //Конструктор на формата
        public SearchForm()
        {
            InitializeComponent();

            //Указва се вида на lis view контрола
            listView1.View = View.Details;
            //При създаване на формата се прочита съдържанието на файловете
            Model.ReadData();
        }

        //Метод, който се извиква при натикане на бутон "Търси" (за продукти)
        private void SearchByItems_Click(object sender, EventArgs e)
        {
            //Изчиства се съдържанието на list view контрола
            listView1.Clear();

            //Извършва се търсене по попълнените от потребителя критерии. Изпозлва се метод Model.SearchItems
            List<Item> FoundItems = Model.SearchItems(ItemName.Text, ItemProvider.Text);

            //Проверка дали методът Model.SearchItems е върнал null. Ако не е върнал null, значи търсенето е успешно и се попълва list view контрола с откритите данни
            if(FoundItems != null)
            {
                //В list view контрола се добавят нужните колони
                listView1.Columns.Add("ID");
                listView1.Columns.Add("Име");
                listView1.Columns.Add("Цена");
                listView1.Columns.Add("Доставчик");

                //Обхождат се всички открити продукти
                foreach (Item i in FoundItems)
                {
                    //Информацията за открития продукт се добавя в list view контрола
                    listView1.Items.Add(new ListViewItem(new string[] { i.ID.ToString(), i.Name, i.Price.ToString(), i.Provider }));
                }

                //Указва се автоматично оразмеряване на list view контрола
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.ColumnContent);
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.HeaderSize);
            }
            //Метода Model.SearchItems е върнал null. Потребителят не е въвел критерии за търсене. Изобразява се екран за грешка
            else
            {
                MessageBox.Show("Не са избрани критерии, по които да се търсят продукти");
            }
        }



        //Метод, който се извиква при натикане на бутон "Търси" (за доставчици)
        private void SearchByProviders_Click(object sender, EventArgs e)
        {
            //Изчиства се съдържанието на list view контрола
            listView1.Clear();

            //Извършва се търсене по попълнените от потребителя критерии. Изпозлва се метод Model.SearchProviders
            List<Provider> FoundProviders = Model.SearchProviders(ProviderName.Text, ProviderNo.Text);

            //Проверка дали методът Model.SearchProviders е върнал null. Ако не е върнал null, значи търсенето е успешно и се попълва list view контрола с откритите данни
            if (FoundProviders != null)
            {
                //В list view контрола се добавят нужните колони
                listView1.Columns.Add("ID");
                listView1.Columns.Add("Име");
                listView1.Columns.Add("Адрес");
                listView1.Columns.Add("Телефон");

                //Обхождат се всички открити доставчици
                foreach (Provider p in FoundProviders)
                {
                    //Информацията за открития доставчик се добавя в list view контрола
                    listView1.Items.Add(new ListViewItem(new string[] { p.ID.ToString(), p.Name, p.Address, p.PhoneNumber }));
                }

                //Указва се автоматично оразмеряване на list view контрола
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.ColumnContent);
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.HeaderSize);
            }
            //Метода Model.SearchProviders е върнал null. Потребителят не е въвел критерии за търсене. Изобразява се екран за грешка
            else
            {
                MessageBox.Show("Не са избрани критерии, по които да се търсят доставчици");
            }
        }

        //Метод, който се извиква при натикане на бутон "Назад"
        private void Back_Click(object sender, EventArgs e)
        {
            //Формата се затваря. Освобождават се заетите ресурси
            this.Close();
        }
    }
}
