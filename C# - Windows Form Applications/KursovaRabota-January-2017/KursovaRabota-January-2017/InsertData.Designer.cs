namespace WindowsFormsApplication1
{
    partial class Form2
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.textBox3 = new System.Windows.Forms.TextBox();
            this.textBox4 = new System.Windows.Forms.TextBox();
            this.textBox5 = new System.Windows.Forms.TextBox();
            this.comboBox1 = new System.Windows.Forms.ComboBox();
            this.labelEgn = new System.Windows.Forms.Label();
            this.labelName = new System.Windows.Forms.Label();
            this.labelTypeOfJob = new System.Windows.Forms.Label();
            this.labelWorkingHours = new System.Windows.Forms.Label();
            this.labelPricePerHour = new System.Windows.Forms.Label();
            this.labelNumberOfWorkingDays = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            this.button2 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // textBox1
            // 
            this.textBox1.BackColor = System.Drawing.Color.DarkRed;
            this.textBox1.ForeColor = System.Drawing.SystemColors.InactiveBorder;
            this.textBox1.Location = new System.Drawing.Point(280, 41);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(226, 22);
            this.textBox1.TabIndex = 0;
            this.textBox1.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox1_KeyPress);
            // 
            // textBox2
            // 
            this.textBox2.BackColor = System.Drawing.Color.DarkRed;
            this.textBox2.ForeColor = System.Drawing.SystemColors.InactiveBorder;
            this.textBox2.Location = new System.Drawing.Point(280, 80);
            this.textBox2.Name = "textBox2";
            this.textBox2.Size = new System.Drawing.Size(226, 22);
            this.textBox2.TabIndex = 1;
            this.textBox2.TextChanged += new System.EventHandler(this.textBox2_TextChanged);
            // 
            // textBox3
            // 
            this.textBox3.BackColor = System.Drawing.Color.DarkRed;
            this.textBox3.ForeColor = System.Drawing.SystemColors.InactiveBorder;
            this.textBox3.Location = new System.Drawing.Point(280, 162);
            this.textBox3.Name = "textBox3";
            this.textBox3.Size = new System.Drawing.Size(226, 22);
            this.textBox3.TabIndex = 2;
            this.textBox3.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            this.textBox3.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox3_KeyPress);
            // 
            // textBox4
            // 
            this.textBox4.BackColor = System.Drawing.Color.DarkRed;
            this.textBox4.ForeColor = System.Drawing.SystemColors.InactiveBorder;
            this.textBox4.Location = new System.Drawing.Point(280, 201);
            this.textBox4.Name = "textBox4";
            this.textBox4.Size = new System.Drawing.Size(226, 22);
            this.textBox4.TabIndex = 3;
            this.textBox4.TextChanged += new System.EventHandler(this.textBox4_TextChanged);
            // 
            // textBox5
            // 
            this.textBox5.BackColor = System.Drawing.Color.DarkRed;
            this.textBox5.ForeColor = System.Drawing.SystemColors.InactiveBorder;
            this.textBox5.Location = new System.Drawing.Point(280, 242);
            this.textBox5.Name = "textBox5";
            this.textBox5.Size = new System.Drawing.Size(226, 22);
            this.textBox5.TabIndex = 4;
            this.textBox5.TextChanged += new System.EventHandler(this.textBox5_TextChanged);
            this.textBox5.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.textBox5_KeyPress);
            // 
            // comboBox1
            // 
            this.comboBox1.BackColor = System.Drawing.Color.DarkRed;
            this.comboBox1.ForeColor = System.Drawing.SystemColors.InactiveBorder;
            this.comboBox1.FormattingEnabled = true;
            this.comboBox1.Items.AddRange(new object[] {
            "Програмист",
            "Химик",
            "Продавач на зеленчуци",
            "Икономист",
            "Строител",
            "Мияч",
            "Бръснар",
            "Фитнес инструктор",
            "Финансов мениджър",
            "Офис асистент",
            "Брокер",
            "Пиколо",
            "Барман"});
            this.comboBox1.Location = new System.Drawing.Point(280, 117);
            this.comboBox1.Name = "comboBox1";
            this.comboBox1.Size = new System.Drawing.Size(226, 24);
            this.comboBox1.TabIndex = 5;
            this.comboBox1.SelectedIndexChanged += new System.EventHandler(this.comboBox1_SelectedIndexChanged);
            // 
            // labelEgn
            // 
            this.labelEgn.AutoSize = true;
            this.labelEgn.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelEgn.Location = new System.Drawing.Point(32, 41);
            this.labelEgn.Name = "labelEgn";
            this.labelEgn.Size = new System.Drawing.Size(47, 20);
            this.labelEgn.TabIndex = 6;
            this.labelEgn.Text = "ЕГН";
            // 
            // labelName
            // 
            this.labelName.AutoSize = true;
            this.labelName.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelName.Location = new System.Drawing.Point(34, 80);
            this.labelName.Name = "labelName";
            this.labelName.Size = new System.Drawing.Size(45, 20);
            this.labelName.TabIndex = 7;
            this.labelName.Text = "Име";
            // 
            // labelTypeOfJob
            // 
            this.labelTypeOfJob.AutoSize = true;
            this.labelTypeOfJob.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelTypeOfJob.Location = new System.Drawing.Point(34, 121);
            this.labelTypeOfJob.Name = "labelTypeOfJob";
            this.labelTypeOfJob.Size = new System.Drawing.Size(102, 20);
            this.labelTypeOfJob.TabIndex = 8;
            this.labelTypeOfJob.Text = "Длъжност";
            // 
            // labelWorkingHours
            // 
            this.labelWorkingHours.AutoSize = true;
            this.labelWorkingHours.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelWorkingHours.Location = new System.Drawing.Point(34, 162);
            this.labelWorkingHours.Name = "labelWorkingHours";
            this.labelWorkingHours.Size = new System.Drawing.Size(190, 20);
            this.labelWorkingHours.TabIndex = 9;
            this.labelWorkingHours.Text = "Изработени часове";
            // 
            // labelPricePerHour
            // 
            this.labelPricePerHour.AutoSize = true;
            this.labelPricePerHour.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelPricePerHour.Location = new System.Drawing.Point(34, 203);
            this.labelPricePerHour.Name = "labelPricePerHour";
            this.labelPricePerHour.Size = new System.Drawing.Size(122, 20);
            this.labelPricePerHour.TabIndex = 10;
            this.labelPricePerHour.Text = "Цена на час";
            // 
            // labelNumberOfWorkingDays
            // 
            this.labelNumberOfWorkingDays.AutoSize = true;
            this.labelNumberOfWorkingDays.Font = new System.Drawing.Font("Microsoft Sans Serif", 10.2F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.labelNumberOfWorkingDays.Location = new System.Drawing.Point(34, 242);
            this.labelNumberOfWorkingDays.Name = "labelNumberOfWorkingDays";
            this.labelNumberOfWorkingDays.Size = new System.Drawing.Size(179, 20);
            this.labelNumberOfWorkingDays.TabIndex = 11;
            this.labelNumberOfWorkingDays.Text = "Брой работни дни";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(38, 308);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(205, 38);
            this.button1.TabIndex = 12;
            this.button1.Text = "Запази данните";
            this.button1.UseMnemonic = false;
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click_1);
            // 
            // button2
            // 
            this.button2.Location = new System.Drawing.Point(280, 308);
            this.button2.Name = "button2";
            this.button2.Size = new System.Drawing.Size(208, 38);
            this.button2.TabIndex = 13;
            this.button2.Text = "Изход";
            this.button2.UseVisualStyleBackColor = true;
            this.button2.Click += new System.EventHandler(this.button2_Click);
            // 
            // Form2
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(528, 398);
            this.Controls.Add(this.button2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.labelNumberOfWorkingDays);
            this.Controls.Add(this.labelPricePerHour);
            this.Controls.Add(this.labelWorkingHours);
            this.Controls.Add(this.labelTypeOfJob);
            this.Controls.Add(this.labelName);
            this.Controls.Add(this.labelEgn);
            this.Controls.Add(this.comboBox1);
            this.Controls.Add(this.textBox5);
            this.Controls.Add(this.textBox4);
            this.Controls.Add(this.textBox3);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.textBox1);
            this.Name = "Form2";
            this.Text = "Въвеждане на данни";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.TextBox textBox3;
        private System.Windows.Forms.TextBox textBox4;
        private System.Windows.Forms.TextBox textBox5;
        private System.Windows.Forms.ComboBox comboBox1;
        private System.Windows.Forms.Label labelEgn;
        private System.Windows.Forms.Label labelName;
        private System.Windows.Forms.Label labelTypeOfJob;
        private System.Windows.Forms.Label labelWorkingHours;
        private System.Windows.Forms.Label labelPricePerHour;
        private System.Windows.Forms.Label labelNumberOfWorkingDays;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.Button button2;
    }
}