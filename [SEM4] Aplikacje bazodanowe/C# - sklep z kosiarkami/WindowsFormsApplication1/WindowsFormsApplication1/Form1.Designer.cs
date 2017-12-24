namespace WindowsFormsApplication1
{
    partial class Start
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.klientToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.kosiarkaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.producentToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.transakcjaToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.klientToolStripMenuItem,
            this.kosiarkaToolStripMenuItem,
            this.producentToolStripMenuItem,
            this.transakcjaToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(896, 24);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // klientToolStripMenuItem
            // 
            this.klientToolStripMenuItem.Name = "klientToolStripMenuItem";
            this.klientToolStripMenuItem.Size = new System.Drawing.Size(49, 20);
            this.klientToolStripMenuItem.Text = "Klient";
            this.klientToolStripMenuItem.Click += new System.EventHandler(this.klientToolStripMenuItem_Click);
            // 
            // kosiarkaToolStripMenuItem
            // 
            this.kosiarkaToolStripMenuItem.Name = "kosiarkaToolStripMenuItem";
            this.kosiarkaToolStripMenuItem.Size = new System.Drawing.Size(63, 20);
            this.kosiarkaToolStripMenuItem.Text = "Kosiarka";
            this.kosiarkaToolStripMenuItem.Click += new System.EventHandler(this.kosiarkaToolStripMenuItem_Click_1);
            // 
            // producentToolStripMenuItem
            // 
            this.producentToolStripMenuItem.Name = "producentToolStripMenuItem";
            this.producentToolStripMenuItem.Size = new System.Drawing.Size(74, 20);
            this.producentToolStripMenuItem.Text = "Producent";
            this.producentToolStripMenuItem.Click += new System.EventHandler(this.producentToolStripMenuItem_Click_1);
            // 
            // transakcjaToolStripMenuItem
            // 
            this.transakcjaToolStripMenuItem.Name = "transakcjaToolStripMenuItem";
            this.transakcjaToolStripMenuItem.Size = new System.Drawing.Size(75, 20);
            this.transakcjaToolStripMenuItem.Text = "Transakcja";
            this.transakcjaToolStripMenuItem.Click += new System.EventHandler(this.transakcjaToolStripMenuItem_Click_1);
            // 
            // Start
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(896, 540);
            this.Controls.Add(this.menuStrip1);
            this.IsMdiContainer = true;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "Start";
            this.Text = "Seweryn Rutkowski - sklep z kosiarkami";
            this.Load += new System.EventHandler(this.Start_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem klientToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem kosiarkaToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem producentToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem transakcjaToolStripMenuItem;
    }
}

