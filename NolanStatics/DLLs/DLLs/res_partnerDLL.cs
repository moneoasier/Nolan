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
    public partial class res_partnerDLL : UserControl
    {
        public res_partnerDLL()
        {
            InitializeComponent();
            this.res_partnerTableAdapter.Fill(this.nolanDataSet.res_partner);
        }

    }
}
