using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace KursovaRabota_January_2017
{
    public partial class SearchByName : Form
    {
        public SearchByName()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox1.Text.Length > 0)
            {
                dataGridView1.Rows.Clear();
                FileStream f = new FileStream("BinaryData.DAT", FileMode.OpenOrCreate);
                BinaryReader br = new BinaryReader(f);
                while (f.Position < f.Length)
                {
                    string egn = br.ReadString();
                    string ime = br.ReadString();
                    string dlajnost = br.ReadString();
                    double chas = br.ReadDouble();
                    double cena = br.ReadDouble();
                    double dni = br.ReadDouble();
                    if (ime.Contains(textBox1.Text.ToUpper()))
                        dataGridView1.Rows.Add(egn, ime, dlajnost, chas, cena, dni, chas * cena);
                }
                f.Close();
            }
            else MessageBox.Show("Няма намерени данни!");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Сигурни ли сте?", "Излизане",
                    MessageBoxButtons.YesNo,
                    MessageBoxIcon.Question) == DialogResult.Yes)
                Close();
        }
    }
}
