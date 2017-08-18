using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;

namespace primer1
{
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.Rows.Clear();
            if (comboBox1.SelectedIndex != -1)
            {
                FileStream f = new FileStream("PETROL.DAT", FileMode.OpenOrCreate);
                BinaryReader br = new BinaryReader(f);

                double sumirane = 0;
                int count = 0;
                while (f.Position < f.Length)
                {
                    string r = br.ReadString();
                    int vid = br.ReadInt32();
                    int gor = br.ReadInt32();
                    double c = br.ReadDouble();
                    double l = br.ReadDouble();
                    if (comboBox1.SelectedIndex == vid)
                    {
                        dataGridView1.Rows.Add(++count, r, gor, c * l);
                        sumirane = sumirane + c * l;
                    }

                }
                f.Close();
                label2.Text = "ОБЩО СУМА: " + sumirane + " лв.";
            }
            else MessageBox.Show("Идиот, избери нещо !");
        }
    }
}
