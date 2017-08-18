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
    public partial class StartForm : Form
    {
        //Конструктор на формата
        public StartForm()
        {
            InitializeComponent();
        }

        //Метод, който се извиква при натикане на бутон "Напред" (за Работа с продукти)
        private void ToItems_Click(object sender, EventArgs e)
        {
            //Отваря се формата за работа с продукти
            new ItemsForm().ShowDialog();
        }

        //Метод, който се извиква при натикане на бутон "Напред" (за Работа с доставчици)
        private void ToProviders_Click(object sender, EventArgs e)
        {
            //Отваря се формата за работа с доставчици
            new ProvidersForm().ShowDialog();
        }

        //Метод, който се извиква при натикане на бутон "Напред" (за Справки)
        private void ToReports_Click(object sender, EventArgs e)
        {
            //Отваря се формата за справки
            new ReportForm().ShowDialog();
        }

        //Метод, който се извиква при натикане на бутон "Напред" (за Търсене)
        private void ToSearch_Click(object sender, EventArgs e)
        {
            //Отваря се формата за търсене
            new SearchForm().ShowDialog();
        }
    }
}
