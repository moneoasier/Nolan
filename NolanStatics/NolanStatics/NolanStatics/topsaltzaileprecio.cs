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
    public partial class Topsaltzaileprecio : Form
    {
        hr_employee1TableAdapter hr_employee1TableAdapter = new hr_employee1TableAdapter();
            NolanDataSet nolanDBDataSet = new NolanDataSet();
        public Topsaltzaileprecio()
        {
            InitializeComponent();
            hr_employee1TableAdapter.Fill(this.nolanDBDataSet.hr_employee1);
            chart1.DataSource = hr_employee1TableAdapter.GetDataBy().Select();
            chart1.Series[0].YValueMembers = "totala";
            chart1.Series[0].XValueMember = "name";
            chart1.DataBind();
        }

        private void panel1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
