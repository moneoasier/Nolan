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
using System.Windows.Forms.DataVisualization.Charting;

namespace NolanStatics
{
    public partial class SalmentaLangileForm : Form
    {
        public SalmentaLangileForm()
        {
            InitializeComponent();
            conexionbd conexion = new conexionbd();
            conexion.abrir();

            string sententzia = "SELECT hr_employee.name, COUNT(sale_order.user_id) " +
                                 "FROM sale_order INNER JOIN " +
                                 "hr_employee ON sale_order.user_id = hr_employee.user_id " +
                                 "GROUP BY hr_employee.name; ";

            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {

                    Series serie = sal_lan.Series.Add((lector.GetValue(0).ToString()));
                    serie.Label = lector.GetValue(1).ToString();
                    serie.Points.Add(int.Parse(lector.GetValue(1).ToString()));

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }
        }

        private void panel1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
