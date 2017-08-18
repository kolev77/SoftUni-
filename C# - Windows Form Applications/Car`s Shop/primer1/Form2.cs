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
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void textBox3_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((e.KeyChar < '0' || e.KeyChar > '9') &&
                e.KeyChar!=(char)(8)) e.KeyChar = (char)(0);
        }

        private void textBox3_KeyUp(object sender, KeyEventArgs e)
        {

        }

        private void Form2_Shown(object sender, EventArgs e)
        {
            comboBox1.SelectedIndex = 0;
            comboBox2.SelectedIndex = 0;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length > 0 && textBox2.Text != "" && textBox3.Text != "")
            {
                FileStream fs = new FileStream("PETROL.DAT",FileMode.Append);
                BinaryWriter bw = new BinaryWriter(fs);

                string rn = textBox1.Text.ToUpper();
                int mps = comboBox1.SelectedIndex;
                int oil = comboBox2.SelectedIndex;
                double cena = double.Parse(textBox2.Text);
                double litri= double.Parse(textBox3.Text);

                bw.Write(rn); bw.Write(mps); bw.Write(oil); bw.Write(cena); bw.Write(litri);
           
                fs.Close();
                MessageBox.Show("Данните са записани !");
            }
            else
            {
                MessageBox.Show("Липсват попълнени данни!");
                textBox1.Focus();
            }
        }

     

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {
            if( textBox3.Text.Length>0 )
            {
                double cena = double.Parse(textBox2.Text);
                double kol = double.Parse(textBox3.Text);
                double suma = kol * cena;
                label6.Text = "СУМА :"+suma+" лв.";
            }
        }
    }
}
