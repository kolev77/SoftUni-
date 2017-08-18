namespace Warehouse
{
    partial class ReportForm
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
            this.listView1 = new System.Windows.Forms.ListView();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.SortItems = new System.Windows.Forms.Button();
            this.SortByProvider = new System.Windows.Forms.CheckBox();
            this.SortByPrice = new System.Windows.Forms.CheckBox();
            this.SortByItemName = new System.Windows.Forms.CheckBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.SortByProviders = new System.Windows.Forms.Button();
            this.SortByAddress = new System.Windows.Forms.CheckBox();
            this.SortByProviderName = new System.Windows.Forms.CheckBox();
            this.Back = new System.Windows.Forms.Button();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // listView1
            // 
            this.listView1.Location = new System.Drawing.Point(16, 178);
            this.listView1.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.listView1.Name = "listView1";
            this.listView1.Size = new System.Drawing.Size(668, 325);
            this.listView1.TabIndex = 0;
            this.listView1.UseCompatibleStateImageBehavior = false;
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.SortItems);
            this.groupBox1.Controls.Add(this.SortByProvider);
            this.groupBox1.Controls.Add(this.SortByPrice);
            this.groupBox1.Controls.Add(this.SortByItemName);
            this.groupBox1.Location = new System.Drawing.Point(16, 16);
            this.groupBox1.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Padding = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox1.Size = new System.Drawing.Size(669, 69);
            this.groupBox1.TabIndex = 1;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Сортиране на продукти";
            // 
            // SortItems
            // 
            this.SortItems.Location = new System.Drawing.Point(553, 25);
            this.SortItems.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortItems.Name = "SortItems";
            this.SortItems.Size = new System.Drawing.Size(100, 28);
            this.SortItems.TabIndex = 3;
            this.SortItems.Text = "Сортирай";
            this.SortItems.UseVisualStyleBackColor = true;
            this.SortItems.Click += new System.EventHandler(this.SortItems_Click);
            // 
            // SortByProvider
            // 
            this.SortByProvider.AutoSize = true;
            this.SortByProvider.Location = new System.Drawing.Point(345, 28);
            this.SortByProvider.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortByProvider.Name = "SortByProvider";
            this.SortByProvider.Size = new System.Drawing.Size(194, 21);
            this.SortByProvider.TabIndex = 2;
            this.SortByProvider.Text = "Сортиране по доставчик";
            this.SortByProvider.UseVisualStyleBackColor = true;
            // 
            // SortByPrice
            // 
            this.SortByPrice.AutoSize = true;
            this.SortByPrice.Location = new System.Drawing.Point(175, 28);
            this.SortByPrice.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortByPrice.Name = "SortByPrice";
            this.SortByPrice.Size = new System.Drawing.Size(158, 21);
            this.SortByPrice.TabIndex = 1;
            this.SortByPrice.Text = "Сортиране по цена";
            this.SortByPrice.UseVisualStyleBackColor = true;
            // 
            // SortByItemName
            // 
            this.SortByItemName.AutoSize = true;
            this.SortByItemName.Location = new System.Drawing.Point(9, 28);
            this.SortByItemName.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortByItemName.Name = "SortByItemName";
            this.SortByItemName.Size = new System.Drawing.Size(151, 21);
            this.SortByItemName.TabIndex = 0;
            this.SortByItemName.Text = "Сортиране по име";
            this.SortByItemName.UseVisualStyleBackColor = true;
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.SortByProviders);
            this.groupBox2.Controls.Add(this.SortByAddress);
            this.groupBox2.Controls.Add(this.SortByProviderName);
            this.groupBox2.Location = new System.Drawing.Point(16, 92);
            this.groupBox2.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Padding = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.groupBox2.Size = new System.Drawing.Size(669, 69);
            this.groupBox2.TabIndex = 2;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Сортиране на доставчици";
            // 
            // SortByProviders
            // 
            this.SortByProviders.Location = new System.Drawing.Point(553, 26);
            this.SortByProviders.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortByProviders.Name = "SortByProviders";
            this.SortByProviders.Size = new System.Drawing.Size(100, 28);
            this.SortByProviders.TabIndex = 7;
            this.SortByProviders.Text = "Сортирай";
            this.SortByProviders.UseVisualStyleBackColor = true;
            this.SortByProviders.Click += new System.EventHandler(this.SortByProviders_Click);
            // 
            // SortByAddress
            // 
            this.SortByAddress.AutoSize = true;
            this.SortByAddress.Location = new System.Drawing.Point(175, 30);
            this.SortByAddress.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortByAddress.Name = "SortByAddress";
            this.SortByAddress.Size = new System.Drawing.Size(165, 21);
            this.SortByAddress.TabIndex = 5;
            this.SortByAddress.Text = "Сортиране по адрес";
            this.SortByAddress.UseVisualStyleBackColor = true;
            // 
            // SortByProviderName
            // 
            this.SortByProviderName.AutoSize = true;
            this.SortByProviderName.Location = new System.Drawing.Point(9, 30);
            this.SortByProviderName.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.SortByProviderName.Name = "SortByProviderName";
            this.SortByProviderName.Size = new System.Drawing.Size(151, 21);
            this.SortByProviderName.TabIndex = 4;
            this.SortByProviderName.Text = "Сортиране по име";
            this.SortByProviderName.UseVisualStyleBackColor = true;
            // 
            // Back
            // 
            this.Back.Location = new System.Drawing.Point(301, 518);
            this.Back.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Back.Name = "Back";
            this.Back.Size = new System.Drawing.Size(100, 28);
            this.Back.TabIndex = 3;
            this.Back.Text = "Назад";
            this.Back.UseVisualStyleBackColor = true;
            this.Back.Click += new System.EventHandler(this.Back_Click);
            // 
            // ReportForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(701, 561);
            this.Controls.Add(this.Back);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Controls.Add(this.listView1);
            this.Margin = new System.Windows.Forms.Padding(4, 4, 4, 4);
            this.Name = "ReportForm";
            this.ShowIcon = false;
            this.Text = "Справки";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.ListView listView1;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Button SortItems;
        private System.Windows.Forms.CheckBox SortByProvider;
        private System.Windows.Forms.CheckBox SortByPrice;
        private System.Windows.Forms.CheckBox SortByItemName;
        private System.Windows.Forms.Button SortByProviders;
        private System.Windows.Forms.CheckBox SortByAddress;
        private System.Windows.Forms.CheckBox SortByProviderName;
        private System.Windows.Forms.Button Back;
    }
}