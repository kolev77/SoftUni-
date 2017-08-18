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
    public partial class Form6 : Form
    {
        public Form6()
        {
            InitializeComponent();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string[] imena = { "Бензин", "Дизел", "Газ" };
            double[] litri = new double[3];
            double[] sumi = new double[3];

            FileStream f = new FileStream("PETROL.DAT", FileMode.OpenOrCreate);
            BinaryReader br = new BinaryReader(f);

            int count = 0;
            while (f.Position < f.Length)
            {
                string r = br.ReadString();
                int vid = br.ReadInt32();
                int gor = br.ReadInt32();
                double c = br.ReadDouble();
                double l = br.ReadDouble();

                litri[gor] += l;
                sumi[gor] += c * l;
            }
            f.Close();
            StreamWriter txt = new StreamWriter("OTCHET.TXT");

            txt.WriteLine("ФИРМА \"ИЗМАМА\"ООД - гр.Голямо Търново");
            txt.WriteLine();
            txt.WriteLine();
            txt.WriteLine("ОБОБЩЕН ОТЧЕТ НА ГОРИВАТА");
            txt.WriteLine();
            txt.WriteLine("============================================");
            txt.WriteLine("ГОРИВО           ЛИТРИ             СУМА ");
            txt.WriteLine("============================================");
            double ssss = 0;
            for (int x = 0; x < 3; x++)
            {
                txt.WriteLine(imena[x] + "\t\t" + litri[x] + "\t\t" + sumi[x]);
                ssss += sumi[x];
            }
            txt.WriteLine("============================================");
            txt.WriteLine("\t\t\tОБЩО :  "+ssss);
            txt.WriteLine("============================================");
            txt.WriteLine();
            txt.WriteLine();
            txt.WriteLine();
            txt.WriteLine( DateTime.Now );
            txt.WriteLine("\t\t\tПодпис: ............");
            txt.Close();
            MessageBox.Show("Файла OTCHET.TXT е създаден.");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if( File.Exists("OTCHET.TXT") )
            {
                listBox1.Items.Clear();
                StreamReader read = new StreamReader("OTCHET.TXT");
                while( !read.EndOfStream )
                {
                    string line = read.ReadLine();
                    listBox1.Items.Add(line);
                }
                    

                read.Close();
            }
        }
    }
}
