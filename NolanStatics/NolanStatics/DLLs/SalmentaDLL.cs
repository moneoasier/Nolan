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
    public partial class SalmentaDLL : UserControl
    {
        public SalmentaDLL()
        {
            InitializeComponent();
            this.sale_orderTableAdapter.Fill(this.nolanDataSet.sale_order);
        }
    }
}
