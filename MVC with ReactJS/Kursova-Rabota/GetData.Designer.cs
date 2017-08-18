namespace Kursova_Rabota
{
    partial class GetData
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
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.checkBoxByFunc = new System.Windows.Forms.CheckBox();
            this.CheckBoxByWorkedTime = new System.Windows.Forms.CheckBox();
            this.SearchByEGN = new System.Windows.Forms.TextBox();
            this.SearchByName = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.SearchByItems = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(42, 223);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(942, 220);
            this.dataGridView1.TabIndex = 0;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.checkBoxByFunc);
            this.groupBox1.Controls.Add(this.CheckBoxByWorkedTime);
            this.groupBox1.Controls.Add(this.SearchByEGN);
            this.groupBox1.Controls.Add(this.SearchByName);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.SearchByItems);
            this.groupBox1.Location = new System.Drawing.Point(42, 28);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(4);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(4);
            this.groupBox1.Size = new System.Drawing.Size(942, 155);
            this.groupBox1.TabIndex = 6;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Търсене на работници";
            // 
            // checkBoxByFunc
            // 
            this.checkBoxByFunc.AutoSize = true;
            this.checkBoxByFunc.Location = new System.Drawing.Point(370, 31);
            this.checkBoxByFunc.Margin = new System.Windows.Forms.Padding(4);
            this.checkBoxByFunc.Name = "checkBoxByFunc";
            this.checkBoxByFunc.Size = new System.Drawing.Size(191, 21);
            this.checkBoxByFunc.TabIndex = 8;
            this.checkBoxByFunc.Text = "Изваждане по длъжност";
            this.checkBoxByFunc.UseVisualStyleBackColor = true;
            this.checkBoxByFunc.CheckedChanged += new System.EventHandler(this.checkBoxByFunc_CheckedChanged);
            // 
            // CheckBoxByWorkedTime
            // 
            this.CheckBoxByWorkedTime.AutoSize = true;
            this.CheckBoxByWorkedTime.Location = new System.Drawing.Point(370, 60);
            this.CheckBoxByWorkedTime.Margin = new System.Windows.Forms.Padding(4);
            this.CheckBoxByWorkedTime.Name = "CheckBoxByWorkedTime";
            this.CheckBoxByWorkedTime.Size = new System.Drawing.Size(403, 21);
            this.CheckBoxByWorkedTime.TabIndex = 7;
            this.CheckBoxByWorkedTime.Text = "Изваждане на работник с най-много изработени часове";
            this.CheckBoxByWorkedTime.UseVisualStyleBackColor = true;
            this.CheckBoxByWorkedTime.CheckedChanged += new System.EventHandler(this.ChechBoxByWorkedTime_CheckedChanged);
            // 
            // SearchByEGN
            // 
            this.SearchByEGN.Location = new System.Drawing.Point(191, 78);
            this.SearchByEGN.Margin = new System.Windows.Forms.Padding(4);
            this.SearchByEGN.Name = "SearchByEGN";
            this.SearchByEGN.Size = new System.Drawing.Size(132, 22);
            this.SearchByEGN.TabIndex = 7;
            // 
            // SearchByName
            // 
            this.SearchByName.Location = new System.Drawing.Point(191, 31);
            this.SearchByName.Margin = new System.Windows.Forms.Padding(4);
            this.SearchByName.Name = "SearchByName";
            this.SearchByName.Size = new System.Drawing.Size(132, 22);
            this.SearchByName.TabIndex = 6;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(8, 81);
            this.label2.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(116, 17);
            this.label2.TabIndex = 5;
            this.label2.Text = "Търсене по ЕГН";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(8, 39);
            this.label1.Margin = new System.Windows.Forms.Padding(4, 0, 4, 0);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(114, 17);
            this.label1.TabIndex = 4;
            this.label1.Text = "Търсене по име";
            // 
            // SearchByItems
            // 
            this.SearchByItems.Location = new System.Drawing.Point(224, 119);
            this.SearchByItems.Margin = new System.Windows.Forms.Padding(4);
            this.SearchByItems.Name = "SearchByItems";
            this.SearchByItems.Size = new System.Drawing.Size(100, 28);
            this.SearchByItems.TabIndex = 3;
            this.SearchByItems.Text = "Търси";
            this.SearchByItems.UseVisualStyleBackColor = true;
            this.SearchByItems.Click += new System.EventHandler(this.SearchByItems_Click);
            // 
            // GetData
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1035, 499);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.dataGridView1);
            this.Name = "GetData";
            this.Text = "GetData";
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.TextBox SearchByEGN;
        private System.Windows.Forms.TextBox SearchByName;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button SearchByItems;
        private System.Windows.Forms.CheckBox CheckBoxByWorkedTime;
        private System.Windows.Forms.CheckBox checkBoxByFunc;
    }
}