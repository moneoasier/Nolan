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
    public partial class KategoriakDLL : UserControl
    {
        public KategoriakDLL()
        {
            InitializeComponent();
            this.product_categoryTableAdapter.Fill(this.nolanDataSet.product_category);
        }
    }
}
