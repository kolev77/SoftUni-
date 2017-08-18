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
    public partial class ReportForm : Form
    {
        //Конструктор на формата
        public ReportForm()
        {
            InitializeComponent();

            //Указва се вида на lis view контрола
            listView1.View = View.Details;
            //При създаване на формата се прочита съдържанието на файловете
            Model.ReadData();
        }

        //Метод, който се извиква при натикане на бутон "Сортирай" (за продукти)
        private void SortItems_Click(object sender, EventArgs e)
        {
            //Изчиства се съдържанието на list view контрола
            listView1.Clear();

            //Извършва се сортиране по попълнените от потребителя критерии. Изпозлва се метод Model.SortItems
            List<Item> SortedItems = Model.SortItems(SortByItemName.Checked, SortByPrice.Checked, SortByProvider.Checked);

            //Проверка дали методът Model.SortItems е върнал null. Ако не е върнал null, значи сортирането е успешно и се попълва list view контрола със сортираните данни
            if (SortedItems != null)
            {
                //В list view контрола се добавят нужните колони
                listView1.Columns.Add("ID");
                listView1.Columns.Add("Име");
                listView1.Columns.Add("Цена");
                listView1.Columns.Add("Доставчик");

                //Обхождат се сортираните продукти
                foreach (Item i in SortedItems)
                {
                    //Информацията за поредния продукт се добавя в list view контрола
                    listView1.Items.Add(new ListViewItem(new string[] { i.ID.ToString(), i.Name, i.Price.ToString(), i.Provider }));
                }

                //Указва се автоматично оразмеряване на list view контрола
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.ColumnContent);
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.HeaderSize);
            }
            //Метода Model.SortItems е върнал null. Потребителят не е въвел критерии за сортиране. Изобразява се екран за грешка
            else
            {
                MessageBox.Show("Не са избрани критерии, по които да се сортират продуктите");
            }
        }

        //Метод, който се извиква при натикане на бутон "Сортирай" (за доставчици)
        private void SortByProviders_Click(object sender, EventArgs e)
        {
            //Изчиства се съдържанието на list view контрола
            listView1.Clear();
            //Извършва се сортиране по попълнените от потребителя критерии. Изпозлва се метод Model.SortProviders
            List<Provider> SortedProviders = Model.SortProviders(SortByProviderName.Checked, SortByAddress.Checked);

            //Проверка дали методът Model.SortProviders е върнал null. Ако не е върнал null, значи сортирането е успешно и се попълва list view контрола със сортираните данни
            if (SortedProviders != null)
            {
                //В list view контрола се добавят нужните колони
                listView1.Columns.Add("ID");
                listView1.Columns.Add("Име");
                listView1.Columns.Add("Адрес");
                listView1.Columns.Add("Телефон");

                //Обхождат се сортираните доставчици
                foreach (Provider p in SortedProviders)
                {
                    //Информацията за поредния доставчик се добавя в list view контрола
                    listView1.Items.Add(new ListViewItem(new string[] { p.ID.ToString(), p.Name, p.Address, p.PhoneNumber }));
                }

                //Указва се автоматично оразмеряване на list view контрола
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.ColumnContent);
                listView1.AutoResizeColumns(ColumnHeaderAutoResizeStyle.HeaderSize);
            }
            //Метода Model.SortProviders е върнал null. Потребителят не е въвел критерии за сортиране. Изобразява се екран за грешка
            else
            {
                MessageBox.Show("Не са избрани критерии, по които да се сортират доставчиците");
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
