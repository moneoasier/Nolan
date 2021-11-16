using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace DLLs
{
    public partial class IrabaziakDLL : UserControl
        
    {
        NolanDataSetTableAdapters.sale_orderTableAdapter sale_OrderTableAdapter = new NolanDataSetTableAdapters.sale_orderTableAdapter();
        NolanDataSet nolanDataSet = new NolanDataSet();
        public IrabaziakDLL()
        {
            InitializeComponent();
            sale_OrderTableAdapter.Fill(this.nolanDataSet.sale_order);

            chart1.DataSource = sale_OrderTableAdapter.GetDataBy().Select().Take(5);

            chart1.Series[0].YValueMembers = "amount_total";
            chart1.Series[0].XValueMember = "name";
            chart1.DataBind();

        }
    }
}
