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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, EventArgs e)
        {

            string[] imena = { "Бензин", "Дизел","Газ"};
            FileStream f = new FileStream("PETROL.DAT",FileMode.OpenOrCreate);
            BinaryReader br = new BinaryReader(f);

            int count = 0;
            while( f.Position<f.Length )
            {
                string r = br.ReadString();
                int vid = br.ReadInt32();
                int gor = br.ReadInt32();
                double c = br.ReadDouble();
                double l = br.ReadDouble();
                dataGridView1.Rows.Add(++count, r,vid,imena[gor],l,c,c*l);

            }
            f.Close();
        }
    }
}
