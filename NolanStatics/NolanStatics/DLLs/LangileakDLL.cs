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
    public partial class LangileakDLL : UserControl
    {
        public LangileakDLL()
        {
            InitializeComponent();
            this.hr_employeeTableAdapter.Fill(this.nolanDataSet.hr_employee);
        }
    }
}
