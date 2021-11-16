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
    public partial class SalmentaErosleForm : Form
    {
        res_partner1TableAdapter res_partner1TableAdapter = new res_partner1TableAdapter();
        NolanDataSet nolanDBDataSet = new NolanDataSet();
        public SalmentaErosleForm()
        {
            InitializeComponent();
            res_partner1TableAdapter.Fill(this.nolanDBDataSet.res_partner1);

            sal_eros.DataSource = res_partner1TableAdapter.GetDataBy().Select();

            sal_eros.Series[0].YValueMembers = "contador";
            sal_eros.Series[0].XValueMember = "name";
            sal_eros.DataBind();
        }
    }
}
