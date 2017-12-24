namespace WindowsFormsApplication1
{
    partial class Kosiarka
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
            this.markaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.modelDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.wagaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.rocznikDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.cenaDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.producentidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewComboBoxColumn();
            this.producentBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.dataSet_baza = new WindowsFormsApplication1.DataSet_baza();
            this.kosiarkaBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.kosiarkaTableAdapter = new WindowsFormsApplication1.DataSet_bazaTableAdapters.KosiarkaTableAdapter();
            this.kosiarkaBindingSource1 = new System.Windows.Forms.BindingSource(this.components);
            this.producentTableAdapter = new WindowsFormsApplication1.DataSet_bazaTableAdapters.ProducentTableAdapter();
            this.txtCena = new System.Windows.Forms.TextBox();
            this.btnZapisz = new System.Windows.Forms.Button();
            this.btnUsun = new System.Windows.Forms.Button();
            this.txtRocznik = new System.Windows.Forms.TextBox();
            this.txtWaga = new System.Windows.Forms.TextBox();
            this.txtModel = new System.Windows.Forms.TextBox();
            this.txtMarka = new System.Windows.Forms.TextBox();
            this.cmbProducent = new System.Windows.Forms.ComboBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.producentBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet_baza)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kosiarkaBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.kosiarkaBindingSource1)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.markaDataGridViewTextBoxColumn,
            this.modelDataGridViewTextBoxColumn,
            this.wagaDataGridViewTextBoxColumn,
            this.rocznikDataGridViewTextBoxColumn,
            this.cenaDataGridViewTextBoxColumn,
            this.producentidDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.kosiarkaBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(12, 12);
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
            // markaDataGridViewTextBoxColumn
            // 
            this.markaDataGridViewTextBoxColumn.DataPropertyName = "marka";
            this.markaDataGridViewTextBoxColumn.HeaderText = "Marka";
            this.markaDataGridViewTextBoxColumn.Name = "markaDataGridViewTextBoxColumn";
            // 
            // modelDataGridViewTextBoxColumn
            // 
            this.modelDataGridViewTextBoxColumn.DataPropertyName = "model";
            this.modelDataGridViewTextBoxColumn.HeaderText = "Model";
            this.modelDataGridViewTextBoxColumn.Name = "modelDataGridViewTextBoxColumn";
            // 
            // wagaDataGridViewTextBoxColumn
            // 
            this.wagaDataGridViewTextBoxColumn.DataPropertyName = "waga";
            this.wagaDataGridViewTextBoxColumn.HeaderText = "Waga";
            this.wagaDataGridViewTextBoxColumn.Name = "wagaDataGridViewTextBoxColumn";
            this.wagaDataGridViewTextBoxColumn.Width = 50;
            // 
            // rocznikDataGridViewTextBoxColumn
            // 
            this.rocznikDataGridViewTextBoxColumn.DataPropertyName = "rocznik";
            this.rocznikDataGridViewTextBoxColumn.HeaderText = "Rocznik";
            this.rocznikDataGridViewTextBoxColumn.Name = "rocznikDataGridViewTextBoxColumn";
            this.rocznikDataGridViewTextBoxColumn.Width = 50;
            // 
            // cenaDataGridViewTextBoxColumn
            // 
            this.cenaDataGridViewTextBoxColumn.DataPropertyName = "cena";
            this.cenaDataGridViewTextBoxColumn.HeaderText = "Cena";
            this.cenaDataGridViewTextBoxColumn.Name = "cenaDataGridViewTextBoxColumn";
            this.cenaDataGridViewTextBoxColumn.Width = 75;
            // 
            // producentidDataGridViewTextBoxColumn
            // 
            this.producentidDataGridViewTextBoxColumn.DataPropertyName = "Producent_id";
            this.producentidDataGridViewTextBoxColumn.DataSource = this.producentBindingSource;
            this.producentidDataGridViewTextBoxColumn.DisplayMember = "nazwa";
            this.producentidDataGridViewTextBoxColumn.HeaderText = "Producent";
            this.producentidDataGridViewTextBoxColumn.Name = "producentidDataGridViewTextBoxColumn";
            this.producentidDataGridViewTextBoxColumn.Resizable = System.Windows.Forms.DataGridViewTriState.True;
            this.producentidDataGridViewTextBoxColumn.SortMode = System.Windows.Forms.DataGridViewColumnSortMode.Automatic;
            this.producentidDataGridViewTextBoxColumn.ValueMember = "id";
            this.producentidDataGridViewTextBoxColumn.Width = 170;
            // 
            // producentBindingSource
            // 
            this.producentBindingSource.DataMember = "Producent";
            this.producentBindingSource.DataSource = this.dataSet_baza;
            // 
            // dataSet_baza
            // 
            this.dataSet_baza.DataSetName = "DataSet_baza";
            this.dataSet_baza.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // kosiarkaBindingSource
            // 
            this.kosiarkaBindingSource.DataMember = "Kosiarka";
            this.kosiarkaBindingSource.DataSource = this.dataSet_baza;
            // 
            // kosiarkaTableAdapter
            // 
            this.kosiarkaTableAdapter.ClearBeforeFill = true;
            // 
            // kosiarkaBindingSource1
            // 
            this.kosiarkaBindingSource1.DataMember = "Kosiarka";
            this.kosiarkaBindingSource1.DataSource = this.dataSet_baza;
            // 
            // producentTableAdapter
            // 
            this.producentTableAdapter.ClearBeforeFill = true;
            // 
            // txtCena
            // 
            this.txtCena.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.kosiarkaBindingSource, "cena", true));
            this.txtCena.Location = new System.Drawing.Point(679, 345);
            this.txtCena.Name = "txtCena";
            this.txtCena.Size = new System.Drawing.Size(175, 20);
            this.txtCena.TabIndex = 1;
            // 
            // btnZapisz
            // 
            this.btnZapisz.Location = new System.Drawing.Point(619, 403);
            this.btnZapisz.Name = "btnZapisz";
            this.btnZapisz.Size = new System.Drawing.Size(113, 61);
            this.btnZapisz.TabIndex = 2;
            this.btnZapisz.Text = "Zapisz";
            this.btnZapisz.UseVisualStyleBackColor = true;
            this.btnZapisz.Click += new System.EventHandler(this.btnZapisz_Click);
            // 
            // btnUsun
            // 
            this.btnUsun.Location = new System.Drawing.Point(738, 403);
            this.btnUsun.Name = "btnUsun";
            this.btnUsun.Size = new System.Drawing.Size(116, 61);
            this.btnUsun.TabIndex = 3;
            this.btnUsun.Text = "Usuń";
            this.btnUsun.UseVisualStyleBackColor = true;
            this.btnUsun.Click += new System.EventHandler(this.btnUsun_Click);
            // 
            // txtRocznik
            // 
            this.txtRocznik.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.kosiarkaBindingSource, "rocznik", true));
            this.txtRocznik.Location = new System.Drawing.Point(679, 297);
            this.txtRocznik.Name = "txtRocznik";
            this.txtRocznik.Size = new System.Drawing.Size(175, 20);
            this.txtRocznik.TabIndex = 4;
            // 
            // txtWaga
            // 
            this.txtWaga.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.kosiarkaBindingSource, "waga", true));
            this.txtWaga.Location = new System.Drawing.Point(679, 247);
            this.txtWaga.Name = "txtWaga";
            this.txtWaga.Size = new System.Drawing.Size(175, 20);
            this.txtWaga.TabIndex = 5;
            // 
            // txtModel
            // 
            this.txtModel.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.kosiarkaBindingSource, "model", true));
            this.txtModel.Location = new System.Drawing.Point(679, 193);
            this.txtModel.Name = "txtModel";
            this.txtModel.Size = new System.Drawing.Size(175, 20);
            this.txtModel.TabIndex = 6;
            // 
            // txtMarka
            // 
            this.txtMarka.DataBindings.Add(new System.Windows.Forms.Binding("Text", this.kosiarkaBindingSource, "marka", true));
            this.txtMarka.Location = new System.Drawing.Point(679, 140);
            this.txtMarka.Name = "txtMarka";
            this.txtMarka.Size = new System.Drawing.Size(175, 20);
            this.txtMarka.TabIndex = 7;
            // 
            // cmbProducent
            // 
            this.cmbProducent.DataBindings.Add(new System.Windows.Forms.Binding("SelectedValue", this.kosiarkaBindingSource, "Producent_id", true));
            this.cmbProducent.DataSource = this.producentBindingSource;
            this.cmbProducent.DisplayMember = "nazwa";
            this.cmbProducent.FormattingEnabled = true;
            this.cmbProducent.Location = new System.Drawing.Point(679, 86);
            this.cmbProducent.Name = "cmbProducent";
            this.cmbProducent.Size = new System.Drawing.Size(175, 21);
            this.cmbProducent.TabIndex = 8;
            this.cmbProducent.ValueMember = "id";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(633, 143);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(40, 13);
            this.label1.TabIndex = 9;
            this.label1.Text = "Marka:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(638, 188);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(39, 13);
            this.label2.TabIndex = 10;
            this.label2.Text = "Model:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(634, 240);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(39, 13);
            this.label3.TabIndex = 11;
            this.label3.Text = "Waga:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(624, 300);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(49, 13);
            this.label4.TabIndex = 12;
            this.label4.Text = "Rocznik:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(638, 348);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(35, 13);
            this.label5.TabIndex = 13;
            this.label5.Text = "Cena:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(608, 89);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(65, 13);
            this.label6.TabIndex = 14;
            this.label6.Text = "Prodeucent:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Font = new System.Drawing.Font("Microsoft Sans Serif", 20.25F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(238)));
            this.label7.Location = new System.Drawing.Point(630, 26);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(92, 31);
            this.label7.TabIndex = 15;
            this.label7.Text = "Dane:";
            // 
            // Kosiarka
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(889, 494);
            this.Controls.Add(this.label7);
            this.Controls.Add(this.label6);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.cmbProducent);
            this.Controls.Add(this.txtMarka);
            this.Controls.Add(this.txtModel);
            this.Controls.Add(this.txtWaga);
            this.Controls.Add(this.txtRocznik);
            this.Controls.Add(this.btnUsun);
            this.Controls.Add(this.btnZapisz);
            this.Controls.Add(this.txtCena);
            this.Controls.Add(this.dataGridView1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "Kosiarka";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Kosiarka";
            this.Load += new System.EventHandler(this.Kosiarka_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.producentBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataSet_baza)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kosiarkaBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.kosiarkaBindingSource1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private DataSet_baza dataSet_baza;
        private System.Windows.Forms.BindingSource kosiarkaBindingSource;
        private DataSet_bazaTableAdapters.KosiarkaTableAdapter kosiarkaTableAdapter;
        private System.Windows.Forms.BindingSource kosiarkaBindingSource1;
        private System.Windows.Forms.BindingSource producentBindingSource;
        private DataSet_bazaTableAdapters.ProducentTableAdapter producentTableAdapter;
        private System.Windows.Forms.TextBox txtCena;
        private System.Windows.Forms.Button btnZapisz;
        private System.Windows.Forms.Button btnUsun;
        private System.Windows.Forms.TextBox txtRocznik;
        private System.Windows.Forms.TextBox txtWaga;
        private System.Windows.Forms.TextBox txtModel;
        private System.Windows.Forms.TextBox txtMarka;
        private System.Windows.Forms.ComboBox cmbProducent;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn markaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn modelDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn wagaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn rocznikDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn cenaDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewComboBoxColumn producentidDataGridViewTextBoxColumn;
    }
}