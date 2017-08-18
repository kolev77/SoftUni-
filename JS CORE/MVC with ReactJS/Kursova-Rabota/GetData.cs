using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Kursova_Rabota
{
    public partial class GetData : Form
    {
        //WorkersList - списък с доставчици, който да се свърже с data grid-a
        List<Worker> WorkersList;
        public GetData()
        {
            InitializeComponent();

            //При създаване на формата се прочита съдържанието на файловете
            Model.ReadData();
            WorkersList = Model.WorkersDictionary.Values.ToList<Worker>();

            //Създава се списък (BindingList), който свързва информацията от списъка WorkersList с информацията, която се изобразява в data grid-a
            BindingList<Worker> ProvidersBindingList = new BindingList<Worker>(WorkersList);
          
            dataGridView1.DataSource = ProvidersBindingList;

        }


        private void SearchByItems_Click(object sender, EventArgs e)
        {

            if (checkBoxByFunc.Checked)
            {
                List<Worker> SortedByFunc = Model.SortData(true, false);
                dataGridView1.Rows.Clear();
                dataGridView1.Refresh();

                BindingList<Worker> SortedByFuncBindingList = new BindingList<Worker>(SortedByFunc);

                dataGridView1.DataSource = SortedByFuncBindingList;
            } else if(CheckBoxByWorkedTime.Checked)
               {
                List<Worker> SortedByWorkedTime = Model.SortData(false, true);
                dataGridView1.Rows.Clear();
                dataGridView1.Refresh();

                BindingList<Worker> SortedByWorkedTimeBindingList = new BindingList<Worker>(SortedByWorkedTime);

                dataGridView1.DataSource = SortedByWorkedTimeBindingList;
            }
        }

        private void checkBoxByFunc_CheckedChanged(object sender, EventArgs e)
        {
            CheckBoxByWorkedTime.CheckState = CheckState.Unchecked;

        }

        private void ChechBoxByWorkedTime_CheckedChanged(object sender, EventArgs e)
        {
            checkBoxByFunc.CheckState = CheckState.Unchecked;
        }
    }
}
