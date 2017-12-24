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
    public partial class Kosiarka : Form
    {
        public Kosiarka()
        {
            InitializeComponent();
        }

        private void Kosiarka_Load(object sender, EventArgs e)
        {
            // TODO: This line of code loads data into the 'dataSet_baza.Producent' table. You can move, or remove it, as needed.
            this.producentTableAdapter.Fill(this.dataSet_baza.Producent);
            // TODO: This line of code loads data into the 'dataSet_baza.Kosiarka' table. You can move, or remove it, as needed.
            this.kosiarkaTableAdapter.Fill(this.dataSet_baza.Kosiarka);

        }

        private void btnZapisz_Click(object sender, EventArgs e)
        {
            DialogResult dr = MessageBox.Show("Czy chcesz zapisać wszystkie zmiany, które wprowadziłeś?",
           "UWAGA!!!", MessageBoxButtons.YesNo);
            if (dr == DialogResult.Yes)
            {
                kosiarkaTableAdapter.Update(dataSet_baza.Kosiarka);
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
                    kosiarkaTableAdapter.Update(dataSet_baza.Kosiarka);
                }
            }
        }
    }
}
