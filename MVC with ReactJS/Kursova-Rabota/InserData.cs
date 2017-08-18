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

namespace Kursova_Rabota
{
  
    public partial class InserData : Form
    {
        public InserData()
        {
            InitializeComponent();
        }

        private void InitializeComponent()
        {
            this.textBoxEGN = new System.Windows.Forms.TextBox();
            this.labelFacultyNumber = new System.Windows.Forms.Label();
            this.labelWorkerName = new System.Windows.Forms.Label();
            this.textBoxWorkerName = new System.Windows.Forms.TextBox();
            this.comboBoxFunction = new System.Windows.Forms.ComboBox();
            this.labelFunction = new System.Windows.Forms.Label();
            this.labelPricePerHour = new System.Windows.Forms.Label();
            this.textBoxPricePerHour = new System.Windows.Forms.TextBox();
            this.labelWorkDays = new System.Windows.Forms.Label();
            this.textBoxWorkingHours = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.label6 = new System.Windows.Forms.Label();
            this.AddButton = new System.Windows.Forms.Button();
            this.labelWorkHours = new System.Windows.Forms.Label();
            this.textBoxWorkHours = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // textBoxEGN
            // 
            this.textBoxEGN.Location = new System.Drawing.Point(158, 30);
            this.textBoxEGN.Name = "textBoxEGN";
            this.textBoxEGN.Size = new System.Drawing.Size(164, 22);
            this.textBoxEGN.TabIndex = 0;
            this.textBoxEGN.TextChanged += new System.EventHandler(this.textBoxMobileNumber_TextChanged);
            // 
            // labelFacultyNumber
            // 
            this.labelFacultyNumber.AutoSize = true;
            this.labelFacultyNumber.Location = new System.Drawing.Point(23, 30);
            this.labelFacultyNumber.Name = "labelFacultyNumber";
            this.labelFacultyNumber.Size = new System.Drawing.Size(43, 17);
            this.labelFacultyNumber.TabIndex = 1;
            this.labelFacultyNumber.Text = "ЕГН :";
            this.labelFacultyNumber.Click += new System.EventHandler(this.label1_Click);
            // 
            // labelWorkerName
            // 
            this.labelWorkerName.AutoSize = true;
            this.labelWorkerName.Location = new System.Drawing.Point(23, 68);
            this.labelWorkerName.Name = "labelWorkerName";
            this.labelWorkerName.Size = new System.Drawing.Size(129, 17);
            this.labelWorkerName.TabIndex = 3;
            this.labelWorkerName.Text = "Име на работник :";
            // 
            // textBoxWorkerName
            // 
            this.textBoxWorkerName.Location = new System.Drawing.Point(158, 68);
            this.textBoxWorkerName.Name = "textBoxWorkerName";
            this.textBoxWorkerName.Size = new System.Drawing.Size(164, 22);
            this.textBoxWorkerName.TabIndex = 2;
            this.textBoxWorkerName.TextChanged += new System.EventHandler(this.textBoxClientName_TextChanged);
            // 
            // comboBoxFunction
            // 
            this.comboBoxFunction.FormattingEnabled = true;
            this.comboBoxFunction.Items.AddRange(new object[] {
            "стругар",
            "шлосер",
            "агроном",
            "аниматор",
            "дърводелец",
            "икономист"});
            this.comboBoxFunction.Location = new System.Drawing.Point(158, 103);
            this.comboBoxFunction.Name = "comboBoxFunction";
            this.comboBoxFunction.Size = new System.Drawing.Size(164, 24);
            this.comboBoxFunction.TabIndex = 4;
            // 
            // labelFunction
            // 
            this.labelFunction.AutoSize = true;
            this.labelFunction.Location = new System.Drawing.Point(23, 106);
            this.labelFunction.Name = "labelFunction";
            this.labelFunction.Size = new System.Drawing.Size(83, 17);
            this.labelFunction.TabIndex = 5;
            this.labelFunction.Text = "Длъжност :";
            // 
            // labelPricePerHour
            // 
            this.labelPricePerHour.AutoSize = true;
            this.labelPricePerHour.Location = new System.Drawing.Point(347, 68);
            this.labelPricePerHour.Name = "labelPricePerHour";
            this.labelPricePerHour.Size = new System.Drawing.Size(97, 17);
            this.labelPricePerHour.TabIndex = 9;
            this.labelPricePerHour.Text = "Цена за час :";
            // 
            // textBoxPricePerHour
            // 
            this.textBoxPricePerHour.Location = new System.Drawing.Point(499, 68);
            this.textBoxPricePerHour.Name = "textBoxPricePerHour";
            this.textBoxPricePerHour.Size = new System.Drawing.Size(164, 22);
            this.textBoxPricePerHour.TabIndex = 8;
            this.textBoxPricePerHour.TextChanged += new System.EventHandler(this.textBoxPricePerHour_TextChanged);
            // 
            // labelWorkDays
            // 
            this.labelWorkDays.Location = new System.Drawing.Point(347, 103);
            this.labelWorkDays.Name = "labelWorkDays";
            this.labelWorkDays.Size = new System.Drawing.Size(125, 47);
            this.labelWorkDays.TabIndex = 11;
            this.labelWorkDays.Text = "Бр. работни дни :";
            // 
            // textBoxWorkingHours
            // 
            this.textBoxWorkingHours.Location = new System.Drawing.Point(499, 106);
            this.textBoxWorkingHours.Name = "textBoxWorkingHours";
            this.textBoxWorkingHours.Size = new System.Drawing.Size(164, 22);
            this.textBoxWorkingHours.TabIndex = 10;
            this.textBoxWorkingHours.TextChanged += new System.EventHandler(this.textBoxUsedMinutes_TextChanged);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(35, 33);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(120, 17);
            this.label1.TabIndex = 1;
            this.label1.Text = "Мобилен номер :";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(159, 29);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(164, 22);
            this.textBox1.TabIndex = 0;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(35, 61);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(46, 17);
            this.label2.TabIndex = 3;
            this.label2.Text = "label2";
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(159, 57);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(164, 22);
            this.textBox2.TabIndex = 2;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(35, 93);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(46, 17);
            this.label3.TabIndex = 5;
            this.label3.Text = "Оператор :";
            // 
            // comboBox1
            // 
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Location = new System.Drawing.Point(159, 86);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(164, 25);
            this.comboBox1.TabIndex = 4;
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(35, 123);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(46, 17);
            this.label4.TabIndex = 7;
            this.label4.Text = "label4";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(35, 150);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(121, 17);
            this.label5.TabIndex = 9;
            this.label5.Text = "Цена за минута :";
            // 
            // textBox3
            // 
            this.textBox3.Location = new System.Drawing.Point(159, 146);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(164, 22);
            this.textBox3.TabIndex = 8;
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(35, 178);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(179, 17);
            this.label6.TabIndex = 11;
            this.label6.Text = "Брой изговорени минути :";
            // 
            // AddButton
            // 
            this.AddButton.BackColor = System.Drawing.Color.DarkGray;
            this.AddButton.Font = new System.Drawing.Font("Arial Narrow", 13.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.AddButton.Location = new System.Drawing.Point(115, 178);
            this.AddButton.Name = "AddButton";
            this.AddButton.Size = new System.Drawing.Size(457, 46);
            this.AddButton.TabIndex = 13;
            this.AddButton.Text = "Добави работник";
            this.AddButton.UseVisualStyleBackColor = false;
            this.AddButton.Click += new System.EventHandler(this.button2_Click);
            // 
            // labelWorkHours
            // 
            this.labelWorkHours.AutoSize = true;
            this.labelWorkHours.Location = new System.Drawing.Point(347, 30);
            this.labelWorkHours.Name = "labelWorkHours";
            this.labelWorkHours.Size = new System.Drawing.Size(146, 17);
            this.labelWorkHours.TabIndex = 15;
            this.labelWorkHours.Text = "Изработени часове :";
            // 
            // textBoxWorkHours
            // 
            this.textBoxWorkHours.Location = new System.Drawing.Point(499, 30);
            this.textBoxWorkHours.Name = "textBoxWorkHours";
            this.textBoxWorkHours.Size = new System.Drawing.Size(164, 22);
            this.textBoxWorkHours.TabIndex = 14;
            this.textBoxWorkHours.TextChanged += new System.EventHandler(this.textBoxWorkHours_TextChanged);
            // 
            // InserData
            // 
            this.ClientSize = new System.Drawing.Size(694, 263);
            this.Controls.Add(this.labelWorkHours);
            this.Controls.Add(this.textBoxWorkHours);
            this.Controls.Add(this.AddButton);
            this.Controls.Add(this.labelWorkDays);
            this.Controls.Add(this.textBoxWorkingHours);
            this.Controls.Add(this.labelPricePerHour);
            this.Controls.Add(this.textBoxPricePerHour);
            this.Controls.Add(this.labelFunction);
            this.Controls.Add(this.comboBoxFunction);
            this.Controls.Add(this.labelWorkerName);
            this.Controls.Add(this.textBoxWorkerName);
            this.Controls.Add(this.labelFacultyNumber);
            this.Controls.Add(this.textBoxEGN);
            this.Name = "InserData";
            this.Text = "Въвеждане на данни";
            this.Load += new System.EventHandler(this.InserData_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        private void InserData_Load(object sender, EventArgs e)
        {

        }

        private TextBox textBoxEGN;
        private Label labelFacultyNumber;
        private Label labelWorkerName;
        private TextBox textBoxWorkerName;
        private ComboBox comboBoxFunction;
        private Label labelFunction;
        private Label labelPricePerHour;
        private TextBox textBoxPricePerHour;
        private Label labelWorkDays;
        private TextBox textBoxWorkingHours;

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private Label label1;
        private TextBox textBox1;
        private Label label2;
        private TextBox textBox2;
        private Label label3;
        private ComboBox comboBox1;
        private Label label4;
        private Label label5;
        private TextBox textBox3;
        private Label label6;
        private Button AddButton;

        private void button2_Click(object sender, EventArgs e)
        {
            if (textBoxEGN.Text.Length == 10)
            {
                Worker worker = new Worker();
                worker.EGN = textBoxEGN.Text;
                worker.WorkerName = textBoxWorkerName.Text;
                worker.Function = comboBoxFunction.Text;
                worker.WorkingHours = int.Parse(textBoxWorkHours.Text);
                worker.PricePerHour = double.Parse(textBoxPricePerHour.Text);
                worker.WorkingDays = double.Parse(textBoxWorkingHours.Text);


                string path = @"../../../Kursova-Rabota/TextData/workers.txt";

                if (!File.Exists(path))
                {
                    using (StreamWriter sw = File.CreateText(path))
                    {

                    }
                }


                using (StreamWriter sw = File.AppendText(path))
                {
                    sw.WriteLine(worker.ToString());
                }
                MessageBox.Show("Успешно добавяне на информация.");

                this.Close();
            }
            else
            {
                MessageBox.Show("ЕГН-то трябва да съдържа 10 цифри.");
            }

        }

        private void textBoxMobileNumber_TextChanged(object sender, EventArgs e)
        {
            if (System.Text.RegularExpressions.Regex.IsMatch(textBoxEGN.Text, "[^0-9]"))
            {
                MessageBox.Show("Моля въведете валидно ЕГН.");
                textBoxEGN.Text = "";
            }
        }

        private void textBoxClientName_TextChanged(object sender, EventArgs e)
        {
            if (System.Text.RegularExpressions.Regex.IsMatch(textBoxWorkerName.Text, "[0-9]"))
            {
                MessageBox.Show("Моля въведете валидно име и фамилия.");
                textBoxWorkerName.Text = "";
            }
        }

       



        private void textBoxPricePerHour_TextChanged(object sender, EventArgs e)
        {
            if (System.Text.RegularExpressions.Regex.IsMatch(textBoxPricePerHour.Text, "[^0-9./]"))
            {
                MessageBox.Show("Моля въведете валидна сума.");
                textBoxPricePerHour.Text = "";
            }
        }

        private void textBoxWorkHours_TextChanged(object sender, EventArgs e)
        {
            if (System.Text.RegularExpressions.Regex.IsMatch(textBoxWorkHours.Text, "[^0-9]"))
            {
                MessageBox.Show("Моля въведете валидни часове.");
                textBoxWorkHours.Text = "";
            }
        }

        private void textBoxUsedMinutes_TextChanged(object sender, EventArgs e)
        {
            if (System.Text.RegularExpressions.Regex.IsMatch(textBoxWorkingHours.Text, "[^0-9]"))
            {
                MessageBox.Show("Моля въведете валиден брой дни.");
                textBoxWorkingHours.Text = "";
            }
        }
    }
}
