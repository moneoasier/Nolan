using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace NolanStatics
{
    public partial class Form1 : Form
    {
        public Form1()
        {

            InitializeComponent();

            SqlConnection conn1 = new SqlConnection("Data Source=192.168.65.2;Initial Catalog=Nolan;User ID=admin");
            conn1.Open();

            SqlCommand cmd1 = new SqlCommand("Select Count(*) as 'KategoriaTot' from dbo.product_category;");
            SqlDataReader reader1;
            reader1 = cmd1.ExecuteReader();
            if (reader1.Read())
            {
                labelCat.Text = reader1["KategoriaTot"].ToString();
            }
        }


        private void btnExit(object sender, EventArgs e)
        {
            Close();
        }

       
    }
}
