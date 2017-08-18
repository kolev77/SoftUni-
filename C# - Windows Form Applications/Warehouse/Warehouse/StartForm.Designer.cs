namespace Warehouse
{
    partial class StartForm
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
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.ToItems = new System.Windows.Forms.Button();
            this.ToProviders = new System.Windows.Forms.Button();
            this.ToReports = new System.Windows.Forms.Button();
            this.ToSearch = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(23, 28);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(97, 13);
            this.label1.TabIndex = 0;
            this.label1.Text = "Работа със стоки";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(23, 62);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(113, 13);
            this.label2.TabIndex = 1;
            this.label2.Text = "Работа с доставчици";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(23, 96);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(50, 13);
            this.label3.TabIndex = 2;
            this.label3.Text = "Справки";
            // 
            // ToItems
            // 
            this.ToItems.Location = new System.Drawing.Point(153, 23);
            this.ToItems.Name = "ToItems";
            this.ToItems.Size = new System.Drawing.Size(75, 23);
            this.ToItems.TabIndex = 3;
            this.ToItems.Text = "Напред";
            this.ToItems.UseVisualStyleBackColor = true;
            this.ToItems.Click += new System.EventHandler(this.ToItems_Click);
            // 
            // ToProviders
            // 
            this.ToProviders.Location = new System.Drawing.Point(153, 57);
            this.ToProviders.Name = "ToProviders";
            this.ToProviders.Size = new System.Drawing.Size(75, 23);
            this.ToProviders.TabIndex = 4;
            this.ToProviders.Text = "Напред";
            this.ToProviders.UseVisualStyleBackColor = true;
            this.ToProviders.Click += new System.EventHandler(this.ToProviders_Click);
            // 
            // ToReports
            // 
            this.ToReports.Location = new System.Drawing.Point(153, 91);
            this.ToReports.Name = "ToReports";
            this.ToReports.Size = new System.Drawing.Size(75, 23);
            this.ToReports.TabIndex = 5;
            this.ToReports.Text = "Напред";
            this.ToReports.UseVisualStyleBackColor = true;
            this.ToReports.Click += new System.EventHandler(this.ToReports_Click);
            // 
            // ToSearch
            // 
            this.ToSearch.Location = new System.Drawing.Point(153, 127);
            this.ToSearch.Name = "ToSearch";
            this.ToSearch.Size = new System.Drawing.Size(75, 24);
            this.ToSearch.TabIndex = 7;
            this.ToSearch.Text = "Напред";
            this.ToSearch.UseVisualStyleBackColor = true;
            this.ToSearch.Click += new System.EventHandler(this.ToSearch_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(23, 132);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(51, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Търсене";
            // 
            // StartForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(250, 171);
            this.Controls.Add(this.ToSearch);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.ToReports);
            this.Controls.Add(this.ToProviders);
            this.Controls.Add(this.ToItems);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "StartForm";
            this.ShowIcon = false;
            this.Text = "Начало";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button ToItems;
        private System.Windows.Forms.Button ToProviders;
        private System.Windows.Forms.Button ToReports;
        private System.Windows.Forms.Button ToSearch;
        private System.Windows.Forms.Label label4;

    }
}

