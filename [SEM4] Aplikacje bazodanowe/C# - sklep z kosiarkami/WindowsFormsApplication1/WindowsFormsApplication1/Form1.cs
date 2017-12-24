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
    public partial class Start : Form
    {
        public Start()
        {
            InitializeComponent();
        }

        private void Start_Load(object sender, EventArgs e)
        {
            //InitializeComponent();
        }

        private void klientToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Klient klient = new Klient();
            klient.MdiParent = this;
            klient.Show();
        }

        private void kosiarkaToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            Kosiarka kosiarka = new Kosiarka();
            kosiarka.MdiParent = this;
            kosiarka.Show();
        }

        private void producentToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            Producent producent = new Producent();
            producent.MdiParent = this;
            producent.Show();
        }

        private void transakcjaToolStripMenuItem_Click_1(object sender, EventArgs e)
        {
            Transakcja transakcja = new Transakcja();
            transakcja.MdiParent = this;
            transakcja.Show();
        }
    }
}
