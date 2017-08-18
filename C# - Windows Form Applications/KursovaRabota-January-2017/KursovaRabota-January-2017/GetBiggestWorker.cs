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
    public partial class Form5 : Form
    {
        public Form5()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            dataGridView1.Rows.Clear();

            const int N = 1;
            double[] chasove = new double[N];
            string[] imena = new string[N];
            int count = 0;


            FileStream f = new FileStream("BinaryData.DAT", FileMode.Open);
            BinaryReader br = new BinaryReader(f);
            while (f.Position < f.Length)
            {
                string egn = br.ReadString();
                string ime = br.ReadString();
                string dlajnost = br.ReadString();
                double chas = br.ReadDouble();
                double cena = br.ReadDouble();
                double dni = br.ReadDouble();
                if (chasove[0] < chas)
                {
                    chasove[0] = chas; imena[0] = ime;
                    for (int i = 0; i < N - 1; i++)
                        for (int j = i + 1; j < N; j++)
                            if (chasove[i] > chasove[j])
                            {
                                double x = chasove[i]; chasove[i] = chasove[j]; chasove[j] = x;
                                string y = imena[i]; imena[i] = imena[j]; imena[j] = y;
                            }
                }
            }
            f.Close();
            dataGridView1.Rows.Clear();
            for (int i = N - 1; i >= 0; i--) dataGridView1.Rows.Add(++count, imena[i], chasove[i]);

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
