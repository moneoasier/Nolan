using NolanStatics.NolanDataSetTableAdapters;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NolanStatics
{
    public partial class TopSalmentak : Form
    {
        sale_order_line1TableAdapter sale_order_line1TableAdapter = new sale_order_line1TableAdapter();
        NolanDataSet nolanDBDataSet = new NolanDataSet();
        int elNumero = 5;
        public TopSalmentak()

        {
            InitializeComponent();

            fillChart();

        }

        private void TopSalmentak_Load(object sender, EventArgs e)
        {
            // TODO: esta línea de código carga datos en la tabla 'nolanDataSet.sale_order_line1' Puede moverla o quitarla según sea necesario.
            this.sale_order_line1TableAdapter1.Fill(this.nolanDataSet.sale_order_line1);

        }

        private void NumericUpDown1_ValueChanged(object sender, EventArgs e)
        {
            int elNumero = (int)numericUpDown1.Value;
            chart1.DataSource = sale_order_line1TableAdapter.GetDataBy().Select().Take(elNumero);
            sale_order_line1TableAdapter.Fill(this.nolanDBDataSet.sale_order_line1);

            chart1.DataSource = sale_order_line1TableAdapter.GetDataBy().Select().Take(elNumero);

            chart1.Series[0].YValueMembers = "Kopurua";
            chart1.Series[0].XValueMember = "name";
            chart1.DataBind();
        }

        private void fillChart()
        {
            sale_order_line1TableAdapter.Fill(this.nolanDBDataSet.sale_order_line1);

            chart1.DataSource = sale_order_line1TableAdapter.GetDataBy().Select().Take(elNumero);

            chart1.Series[0].YValueMembers = "Kopurua";
            chart1.Series[0].XValueMember = "name";
            chart1.DataBind();
        }

        private void panel1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
