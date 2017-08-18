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
    public partial class Form8 : Form
    {
        public Form8()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
                FileStream f = new FileStream("BinaryData.DAT", FileMode.OpenOrCreate);
                BinaryReader br = new BinaryReader(f);
                StreamWriter txt = new StreamWriter("Data.txt");
                double total = 0;
            txt.WriteLine("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            txt.WriteLine("ЕГН                         Име                           Длъжност            Изработени часове      Брой работни дни    Сума за изплащане в лв.   Ср. отработ. часове на ден");
            txt.WriteLine("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ;

            while (f.Position < f.Length)
                {
                    string egn = br.ReadString();
                    string ime = br.ReadString();
                    string dlajnost = br.ReadString();
                    double chas = br.ReadDouble();
                    double cena = br.ReadDouble();
                    double dni = br.ReadDouble();
                    double sum = chas * cena;
                    double srchas = chas / dni;
                string spime = new String(' ', 18 - ime.Length);
                string spdlajnost = new String(' ', 16-dlajnost.Length);
                string sizrabotenichasove = new String(' ', 16- chas.ToString().Length);
                string sBrojRabotniDni = new String(' ', 16- dni.ToString().Length);
                string sSumaZaIzplashtane = new String(' ', 22- sum.ToString().Length);

                txt.WriteLine(egn + "     " + ime + spime + "         " + dlajnost + spdlajnost + "                 " + chas + sizrabotenichasove+ "             " + dni + sBrojRabotniDni +"             " + sum + sSumaZaIzplashtane+"           " + srchas);
                total += sum;
            }
            txt.WriteLine("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            txt.WriteLine();
            txt.WriteLine("\tОБЩА СУМА :" + total + " лв.");
            txt.WriteLine();
            txt.WriteLine("\tПодпис: ............");
            txt.Close();
            MessageBox.Show("Данните са записани в Data.TXT");
            f.Close();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            listBox1.Items.Clear();
            if (File.Exists("Data.txt"))
            {
                StreamReader txt = new StreamReader("Data.txt");
                while (!txt.EndOfStream)
                {
                    string s = txt.ReadLine();
                    listBox1.Items.Add(s);
                }
                txt.Close();
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Сигурни ли сте?", "Излизане",
                                MessageBoxButtons.YesNo,
                                MessageBoxIcon.Question) == DialogResult.Yes)
                Close();
        }
    }
}

    
