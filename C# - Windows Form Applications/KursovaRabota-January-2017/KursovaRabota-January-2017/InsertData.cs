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

namespace WindowsFormsApplication1
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void textBox1_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((e.KeyChar < '0' || e.KeyChar > '9')
                && e.KeyChar != (char)(8) &&
                e.KeyChar != '.')
                e.KeyChar = (char)(0);
        }
        private void textBox3_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((e.KeyChar < '0' || e.KeyChar > '9')
              && e.KeyChar != (char)(8) &&
              e.KeyChar != '.')
                e.KeyChar = (char)(0);
        }
        private void textBox5_KeyPress(object sender, KeyPressEventArgs e)
        {
            if ((e.KeyChar < '0' || e.KeyChar > '9')
              && e.KeyChar != (char)(8) &&
              e.KeyChar != '.')
                e.KeyChar = (char)(0);
        }
     
     
        private void button1_Click_1(object sender, EventArgs e)
        {
            if (textBox1.Text.Length > 0 && textBox2.Text != "" && textBox3.Text != "" && textBox4.Text != "" && textBox5.Text != "")
            {
                FileStream f = new FileStream("BinaryData.DAT", FileMode.Append);
                BinaryWriter bw = new BinaryWriter(f);
                string egn = textBox1.Text;
                string ime = textBox2.Text.ToUpper();
                string dlaj = comboBox1.Text;
                double chas = double.Parse(textBox3.Text);
                double cena = double.Parse(textBox4.Text);
                double dni = double.Parse(textBox5.Text);
                bw.Write(egn); bw.Write(ime); bw.Write(dlaj); bw.Write(chas); bw.Write(cena); bw.Write(dni);

                f.Close();
                MessageBox.Show("Данните са записани !");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                textBox5.Text = "";
                comboBox1.Text = "";
            }
            else

                MessageBox.Show("Липсват попълнени данни!");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Сигурни ли сте?", "Излизане",
                             MessageBoxButtons.YesNo,
                             MessageBoxIcon.Question) == DialogResult.Yes)
                Close();
        }

        private void textBox5_TextChanged(object sender, EventArgs e)
        {

        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void textBox4_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }
    }
}
