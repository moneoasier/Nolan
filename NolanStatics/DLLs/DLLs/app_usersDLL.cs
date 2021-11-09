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
    public partial class app_usersDLL : UserControl
    {
        public app_usersDLL()
        {
            InitializeComponent();

            this.app_usersTableAdapter.Fill(this.nolanDataSet.app_users);
        }
    }
}
