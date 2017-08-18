namespace Warehouse
{
    partial class SearchForm
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
            this.Back = new System.Windows.Forms.Button();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.ProviderNo = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.ProviderName = new System.Windows.Forms.TextBox();
            this.SearchByProviders = new System.Windows.Forms.Button();
            this.label4 = new System.Windows.Forms.Label();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.ItemProvider = new System.Windows.Forms.TextBox();
            this.ItemName = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.SearchByItems = new System.Windows.Forms.Button();
            this.listView1 = new System.Windows.Forms.ListView();
            this.groupBox2.SuspendLayout();
            this.groupBox1.SuspendLayout();
            this.SuspendLayout();
            // 
            // Back
            // 
            this.Back.Location = new System.Drawing.Point(226, 423);
            this.Back.Name = "Back";
            this.Back.Size = new System.Drawing.Size(75, 23);
            this.Back.TabIndex = 7;
            this.Back.Text = "Назад";
            this.Back.UseVisualStyleBackColor = true;
            this.Back.Click += new System.EventHandler(this.Back_Click);
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.ProviderNo);
            this.groupBox2.Controls.Add(this.label3);
            this.groupBox2.Controls.Add(this.ProviderName);
            this.groupBox2.Controls.Add(this.SearchByProviders);
            this.groupBox2.Controls.Add(this.label4);
            this.groupBox2.Location = new System.Drawing.Point(267, 15);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(247, 126);
            this.groupBox2.TabIndex = 6;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Търсене на доставчици";
            // 
            // ProviderNo
            // 
            this.ProviderNo.Location = new System.Drawing.Point(141, 67);
            this.ProviderNo.Name = "ProviderNo";
            this.ProviderNo.Size = new System.Drawing.Size(100, 20);
            this.ProviderNo.TabIndex = 9;
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(6, 66);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(124, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Търсене по тел. номер";
            // 
            // ProviderName
            // 
            this.ProviderName.Location = new System.Drawing.Point(141, 29);
            this.ProviderName.Name = "ProviderName";
            this.ProviderName.Size = new System.Drawing.Size(100, 20);
            this.ProviderName.TabIndex = 8;
            // 
            // SearchByProviders
            // 
            this.SearchByProviders.Location = new System.Drawing.Point(166, 97);
            this.SearchByProviders.Name = "SearchByProviders";
            this.SearchByProviders.Size = new System.Drawing.Size(75, 23);
            this.SearchByProviders.TabIndex = 7;
            this.SearchByProviders.Text = "Търси";
            this.SearchByProviders.UseVisualStyleBackColor = true;
            this.SearchByProviders.Click += new System.EventHandler(this.SearchByProviders_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(6, 32);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(89, 13);
            this.label4.TabIndex = 6;
            this.label4.Text = "Търсене по име";
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.ItemProvider);
            this.groupBox1.Controls.Add(this.ItemName);
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.SearchByItems);
            this.groupBox1.Location = new System.Drawing.Point(12, 15);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(249, 126);
            this.groupBox1.TabIndex = 5;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Търсене на продукти";
            // 
            // ItemProvider
            // 
            this.ItemProvider.Location = new System.Drawing.Point(143, 63);
            this.ItemProvider.Name = "ItemProvider";
            this.ItemProvider.Size = new System.Drawing.Size(100, 20);
            this.ItemProvider.TabIndex = 7;
            // 
            // ItemName
            // 
            this.ItemName.Location = new System.Drawing.Point(143, 25);
            this.ItemName.Name = "ItemName";
            this.ItemName.Size = new System.Drawing.Size(100, 20);
            this.ItemName.TabIndex = 6;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(6, 66);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(132, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "Търсене по дистрибутор";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(6, 32);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(89, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Търсене по име";
            // 
            // SearchByItems
            // 
            this.SearchByItems.Location = new System.Drawing.Point(168, 97);
            this.SearchByItems.Name = "SearchByItems";
            this.SearchByItems.Size = new System.Drawing.Size(75, 23);
            this.SearchByItems.TabIndex = 3;
            this.SearchByItems.Text = "Търси";
            this.SearchByItems.UseVisualStyleBackColor = true;
            this.SearchByItems.Click += new System.EventHandler(this.SearchByItems_Click);
            // 
            // listView1
            // 
            this.listView1.Location = new System.Drawing.Point(12, 147);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(502, 265);
            this.listView1.TabIndex = 4;
            this.listView1.UseCompatibleStateImageBehavior = false;
            // 
            // SearchForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(526, 458);
            this.Controls.Add(this.Back);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.listView1);
            this.Name = "SearchForm";
            this.ShowIcon = false;
            this.Text = "Търсене";
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button Back;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Button SearchByProviders;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Button SearchByItems;
        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.TextBox ProviderNo;
        private System.Windows.Forms.TextBox ProviderName;
        private System.Windows.Forms.TextBox ItemProvider;
        private System.Windows.Forms.TextBox ItemName;
    }
}