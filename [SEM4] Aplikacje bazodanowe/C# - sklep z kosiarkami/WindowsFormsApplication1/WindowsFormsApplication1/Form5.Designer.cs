namespace WindowsFormsApplication1
{
    partial class Transakcja
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
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.idDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dataDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.platnoscDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.uwagiDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.klientidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewComboBoxColumn();
            this.klientBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.dataSet_baza = new WindowsFormsApplication1.DataSet_baza();
            this.kosiarkaidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewComboBoxColumn();
            this.kosiarkaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.transakcjaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.transakcjaTableAdapter = new WindowsFormsApplication1.DataSet_bazaTableAdapters.TransakcjaTableAdapter();
            this.klientTableAdapter = new WindowsFormsApplication1.DataSet_bazaTableAdapters.KlientTableAdapter();
            this.kosiarkaTableAdapter = new WindowsFormsApplication1.DataSet_bazaTableAdapters.KosiarkaTableAdapter();
            this.txtUwagi = new System.Windows.Forms.TextBox();
            this.txtPlatnosc = new System.Windows.Forms.TextBox();
            this.txtData = new System.Windows.Forms.TextBox();
            this.btnZapisz = new System.Windows.Forms.Button();
            this.btnUsun = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.cmbKlient = new System.Windows.Forms.ComboBox();
            this.cmbKosiarka = new System.Windows.Forms.ComboBox();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.klientBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet_baza)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kosiarkaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.transakcjaBindingSource)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.dataDataGridViewTextBoxColumn,
            this.platnoscDataGridViewTextBoxColumn,
            this.uwagiDataGridViewTextBoxColumn,
            this.klientidDataGridViewTextBoxColumn,
            this.kosiarkaidDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.transakcjaBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(13, 13);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(585, 469);
            this.dataGridView1.TabIndex = 0;
            // 
            // idDataGridViewTextBoxColumn
            // 
            this.idDataGridViewTextBoxColumn.DataPropertyName = "id";
            this.idDataGridViewTextBoxColumn.HeaderText = "id";
            this.idDataGridViewTextBoxColumn.Name = "idDataGridViewTextBoxColumn";
            this.idDataGridViewTextBoxColumn.ReadOnly = true;
            this.idDataGridViewTextBoxColumn.Visible = false;
            // 
            // dataDataGridViewTextBoxColumn
            // 
            this.dataDataGridViewTextBoxColumn.DataPropertyName = "data";
            this.dataDataGridViewTextBoxColumn.HeaderText = "Data";
            this.dataDataGridViewTextBoxColumn.Name = "dataDataGridViewTextBoxColumn";
            this.dataDataGridViewTextBoxColumn.Width = 85;
            // 
            // platnoscDataGridViewTextBoxColumn
            // 
            this.platnoscDataGridViewTextBoxColumn.DataPropertyName = "platnosc";
            this.platnoscDataGridViewTextBoxColumn.HeaderText = "Płatność";
            this.platnoscDataGridViewTextBoxColumn.Name = "platnoscDataGridViewTextBoxColumn";
            // 
            // uwagiDataGridViewTextBoxColumn
            // 
            this.uwagiDataGridViewTextBoxColumn.DataPropertyName = "uwagi";
            this.uwagiDataGridViewTextBoxColumn.HeaderText = "Uwagi";
            this.uwagiDataGridViewTextBoxColumn.Name = "uwagiDataGridViewTextBoxColumn";
            this.uwagiDataGridViewTextBoxColumn.Width = 125;
            // 
            // klientidDataGridViewTextBoxColumn
            // 
            this.klientidDataGridViewTextBoxColumn.DataPropertyName = "Klient_id";
            this.klientidDataGridViewTextBoxColumn.DataSource = this.klientBindingSource;
            this.klientidDataGridViewTextBoxColumn.DisplayMember = "pesel";
            this.klientidDataGridViewTextBoxColumn.HeaderText = "Klient";
            this.klientidDataGridViewTextBoxColumn.Name = "klientidDataGridViewTextBoxColumn";
            this.klientidDataGridViewTextBoxColumn.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.klientidDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.klientidDataGridViewTextBoxColumn.ValueMember = "id";
            this.klientidDataGridViewTextBoxColumn.Width = 125;
            // 
            // klientBindingSource
            // 
            this.klientBindingSource.DataMember = "Klient";
            this.klientBindingSource.DataSource = this.dataSet_baza;
            // 
            // dataSet_baza
            // 
            this.dataSet_baza.DataSetName = "DataSet_baza";
            this.dataSet_baza.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // kosiarkaidDataGridViewTextBoxColumn
            // 
            this.kosiarkaidDataGridViewTextBoxColumn.DataPropertyName = "Kosiarka_id";
            this.kosiarkaidDataGridViewTextBoxColumn.DataSource = this.kosiarkaBindingSource;
            this.kosiarkaidDataGridViewTextBoxColumn.DisplayMember = "model";
            this.kosiarkaidDataGridViewTextBoxColumn.HeaderText = "Kosiarka";
            this.kosiarkaidDataGridViewTextBoxColumn.Name = "kosiarkaidDataGridViewTextBoxColumn";
            this.kosiarkaidDataGridViewTextBoxColumn.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.kosiarkaidDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.kosiarkaidDataGridViewTextBoxColumn.ValueMember = "id";
            this.kosiarkaidDataGridViewTextBoxColumn.Width = 108;
            // 
            // kosiarkaBindingSource
            // 
            this.kosiarkaBindingSource.DataMember = "Kosiarka";
            this.kosiarkaBindingSource.DataSource = this.dataSet_baza;
            // 
            // transakcjaBindingSource
            // 
            this.transakcjaBindingSource.DataMember = "Transakcja";
            this.transakcjaBindingSource.DataSource = this.dataSet_baza;
            // 
            // transakcjaTableAdapter
            // 
            this.transakcjaTableAdapter.ClearBeforeFill = true;
            // 
            // klientTableAdapter
            // 
            this.klientTableAdapter.ClearBeforeFill = true;
            // 
            // kosiarkaTableAdapter
            // 
            this.kosiarkaTableAdapter.ClearBeforeFill = true;
            // 
            // txtUwagi
            // 
            this.txtUwagi.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.transakcjaBindingSource, "uwagi", true));
            this.txtUwagi.Location = new System.Drawing.Point(695, 346);
            this.txtUwagi.Name = "txtUwagi";
            this.txtUwagi.Size = new System.Drawing.Size(176, 20);
            this.txtUwagi.TabIndex = 1;
            // 
            // txtPlatnosc
            // 
            this.txtPlatnosc.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.transakcjaBindingSource, "platnosc", true));
            this.txtPlatnosc.Location = new System.Drawing.Point(694, 292);
            this.txtPlatnosc.Name = "txtPlatnosc";
            this.txtPlatnosc.Size = new System.Drawing.Size(177, 20);
            this.txtPlatnosc.TabIndex = 2;
            // 
            // txtData
            // 
            this.txtData.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.transakcjaBindingSource, "data", true));
            this.txtData.Location = new System.Drawing.Point(694, 237);
            this.txtData.Name = "txtData";
            this.txtData.Size = new System.Drawing.Size(177, 20);
            this.txtData.TabIndex = 3;
            // 
            // btnZapisz
            // 
            this.btnZapisz.Location = new System.Drawing.Point(626, 398);
            this.btnZapisz.Name = "btnZapisz";
            this.btnZapisz.Size = new System.Drawing.Size(117, 44);
            this.btnZapisz.TabIndex = 4;
            this.btnZapisz.Text = "Zapisz";
            this.btnZapisz.UseVisualStyleBackColor = true;
            this.btnZapisz.Click += new System.EventHandler(this.btnZapisz_Click);
            // 
            // btnUsun
            // 
            this.btnUsun.Location = new System.Drawing.Point(749, 398);
            this.btnUsun.Name = "btnUsun";
            this.btnUsun.Size = new System.Drawing.Size(122, 44);
            this.btnUsun.TabIndex = 5;
            this.btnUsun.Text = "Usuń";
            this.btnUsun.UseVisualStyleBackColor = true;
            this.btnUsun.Click += new System.EventHandler(this.btnUsun_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(655, 240);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(33, 13);
            this.label1.TabIndex = 6;
            this.label1.Text = "Data:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(636, 295);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(53, 13);
            this.label2.TabIndex = 7;
            this.label2.Text = "Płatność:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(649, 349);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(40, 13);
            this.label3.TabIndex = 8;
            this.label3.Text = "Uwagi:";
            // 
            // cmbKlient
            // 
            this.cmbKlient.DataBindings.Add(new System.Windows.Forms.Binding("SelectedValue", this.transakcjaBindingSource, "Klient_id", true));
            this.cmbKlient.DataSource = this.klientBindingSource;
            this.cmbKlient.DisplayMember = "pesel";
            this.cmbKlient.Font = new System.Drawing.Font("Microsoft Sans Serif", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.cmbKlient.FormattingEnabled = true;
            this.cmbKlient.Location = new System.Drawing.Point(694, 134);
            this.cmbKlient.Name = "cmbKlient";
            this.cmbKlient.Size = new System.Drawing.Size(177, 24);
            this.cmbKlient.TabIndex = 9;
            this.cmbKlient.ValueMember = "id";
            // 
            // cmbKosiarka
            // 
            this.cmbKosiarka.DataBindings.Add(new System.Windows.Forms.Binding("SelectedValue", this.transakcjaBindingSource, "Kosiarka_id", true));
            this.cmbKosiarka.DataSource = this.kosiarkaBindingSource;
            this.cmbKosiarka.DisplayMember = "model";
            this.cmbKosiarka.FormattingEnabled = true;
            this.cmbKosiarka.Location = new System.Drawing.Point(695, 186);
            this.cmbKosiarka.Name = "cmbKosiarka";
            this.cmbKosiarka.Size = new System.Drawing.Size(177, 21);
            this.cmbKosiarka.TabIndex = 10;
            this.cmbKosiarka.ValueMember = "id";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(638, 189);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(51, 13);
            this.label4.TabIndex = 11;
            this.label4.Text = "Kosiarka:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(653, 137);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(36, 13);
            this.label5.TabIndex = 12;
            this.label5.Text = "Klient:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.label6.Location = new System.Drawing.Point(647, 61);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(92, 31);
            this.label6.TabIndex = 13;
            this.label6.Text = "Dane:";
            // 
            // Transakcja
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(889, 494);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.cmbKosiarka);
            this.Controls.Add(this.cmbKlient);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.btnUsun);
            this.Controls.Add(this.btnZapisz);
            this.Controls.Add(this.txtData);
            this.Controls.Add(this.txtPlatnosc);
            this.Controls.Add(this.txtUwagi);
            this.Controls.Add(this.dataGridView1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Transakcja";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Transakcja";
            this.Load += new System.EventHandler(this.Transakcja_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.klientBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet_baza)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kosiarkaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.transakcjaBindingSource)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private DataSet_baza dataSet_baza;
        private System.Windows.Forms.BindingSource transakcjaBindingSource;
        private DataSet_bazaTableAdapters.TransakcjaTableAdapter transakcjaTableAdapter;
        private System.Windows.Forms.BindingSource klientBindingSource;
        private DataSet_bazaTableAdapters.KlientTableAdapter klientTableAdapter;
        private System.Windows.Forms.BindingSource kosiarkaBindingSource;
        private DataSet_bazaTableAdapters.KosiarkaTableAdapter kosiarkaTableAdapter;
        private System.Windows.Forms.TextBox txtUwagi;
        private System.Windows.Forms.TextBox txtPlatnosc;
        private System.Windows.Forms.TextBox txtData;
        private System.Windows.Forms.Button btnZapisz;
        private System.Windows.Forms.Button btnUsun;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.ComboBox cmbKlient;
        private System.Windows.Forms.ComboBox cmbKosiarka;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dataDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn platnoscDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn uwagiDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewComboBoxColumn klientidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewComboBoxColumn kosiarkaidDataGridViewTextBoxColumn;
    }
}