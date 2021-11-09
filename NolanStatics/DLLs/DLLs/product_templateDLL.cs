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
    public partial class product_templateDLL : UserControl
    {
        public product_templateDLL()
        {
            InitializeComponent();

            this.product_templateTableAdapter.Fill(this.nolanDataSet.product_template);
        }
    }
}
