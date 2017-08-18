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
    public partial class Form4 : Form
    {
        public Form4()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.Rows.Clear();
            FileStream f = new FileStream("BinaryData.DAT", FileMode.OpenOrCreate);
            BinaryReader br = new BinaryReader(f);
            int count = 0;
            while (f.Position < f.Length)
            {
                string egn = br.ReadString();
                string ime = br.ReadString();
                string dlajnost = br.ReadString();
                double chas = br.ReadDouble();
                double cena = br.ReadDouble();
                double dni = br.ReadDouble();
                if (comboBox1.Text == dlajnost)
                    dataGridView1.Rows.Add(++count, egn, ime, dlajnost, chas, cena, dni, chas * cena);
            }
            f.Close();
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

