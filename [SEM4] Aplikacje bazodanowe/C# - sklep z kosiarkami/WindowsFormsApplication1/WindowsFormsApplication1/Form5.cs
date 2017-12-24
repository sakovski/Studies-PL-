using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApplication1
{
    public partial class Transakcja : Form
    {
        public Transakcja()
        {
            InitializeComponent();
        }

        private void Transakcja_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'dataSet_baza.Kosiarka' table. You can move, or remove it, as needed.
            this.kosiarkaTableAdapter.Fill(this.dataSet_baza.Kosiarka);
            // TODO: This line of code loads data into the 'dataSet_baza.Klient' table. You can move, or remove it, as needed.
            this.klientTableAdapter.Fill(this.dataSet_baza.Klient);
            // TODO: This line of code loads data into the 'dataSet_baza.Transakcja' table. You can move, or remove it, as needed.
            this.transakcjaTableAdapter.Fill(this.dataSet_baza.Transakcja);

        }

        private void btnZapisz_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Czy chcesz zapisać wszystkie zmiany, które wprowadziłeś?",
         "UWAGA!!!", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                transakcjaTableAdapter.Update(dataSet_baza.Transakcja);
            }
        }

        private void btnUsun_Click(object sender, EventArgs e)
        {
            //sprawdza czy jest zaznaczony wiersz
            if (dataGridView1.CurrentRow != null)
            {
                DialogResult dr = MessageBox.Show("Czy chcesz usunąć rekord?", "Uwaga", MessageBoxButtons.YesNo);
                if (dr == DialogResult.Yes)
                {
                    dataGridView1.CurrentRow.Selected = true;
                    //usuwa zaznaczony wiersz
                    dataGridView1.Rows.Remove(dataGridView1.SelectedRows[0]);
                    transakcjaTableAdapter.Update(dataSet_baza.Transakcja);
                }
            }
        }
    }
}
