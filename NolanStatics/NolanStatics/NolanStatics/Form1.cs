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
        NolanDataSet nolanDBDataSet = new NolanDataSet();
        public Form1()
        {

            InitializeComponent();

            
        }


        private void btnExit(object sender, EventArgs e)
        {
            Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
                

            countKat();
            countLang();
            countIrab();
            countErosle();
            countProd();
            countSalm();
            dataChart1();
            dataChart2();

        
            
        }
        public void dataChart1()
        {
            NolanDataSetTableAdapters.sale_orderTableAdapter sale_orderTableAdapter = new NolanDataSetTableAdapters.sale_orderTableAdapter();



            sale_orderTableAdapter.Fill(this.nolanDBDataSet.sale_order);

            chart1.DataSource = this.nolanDBDataSet.sale_order.GroupBy(b => b.partner_id).ToDictionary(g => g.Key, g => g.Count());

            chart1.Series[0].YValueMembers = "Value";
            chart1.Series[0].XValueMember = "Key";
            chart1.DataBind();
        }
        public void dataChart2()
        {

            /*
                        SalmentaDBDataSetTableAdapters.SalmentaTableAdapter salmentaTableAdapter = new SalmentaDBDataSetTableAdapters.SalmentaTableAdapter();

                        salmentaTableAdapter.Fill(this.salmentaDBDataSet.Salmenta);

                        chart2.DataSource = this.salmentaDBDataSet.Salmenta.GroupBy(b => b.NanBezeroa).ToDictionary(g => g.Key, g => g.Sum(b => b.Zenbatekoa));

                        chart2.Series[0].YValueMembers = "Value";
                        chart2.Series[0].XValueMember = "Key";
                        chart2.DataBind();
                        */
        }
        public void countKat()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();
            string sententzia = "Select count(*) from dbo.product_category";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    labelCat.Text = lector.GetValue(0).ToString();

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }

        }

        public void countLang()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();
            string sententzia = "Select count(*) from dbo.hr_employee";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    
                    
                    labelLang.Text = lector.GetValue(0).ToString();

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }
        }

        public void countIrab()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();
            string sententzia = "Select SUM(amount_total) from dbo.sale_order";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {


                    labelIrab.Text = lector.GetValue(0).ToString()+"€";

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }
        }
        public void countErosle()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();
            string sententzia = "Select Count(*) from dbo.res_partner where signup_type= 'signup'";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {

                    
                    labelErosle.Text = lector.GetValue(0).ToString();

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }
        }

        public void countProd()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();
            string sententzia = "Select Count(*) from dbo.product_template where default_code IS NOT NULL";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {


                    labelProd.Text = lector.GetValue(0).ToString();

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }
        }

        public void countSalm()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();
            string sententzia = "Select Count(*) from dbo.sale_order";
            try
            {
                SqlCommand comando = new SqlCommand(sententzia, conexion.conectarbd);
                SqlDataReader lector = comando.ExecuteReader();
                while (lector.Read())
                {


                    labelSalm.Text = lector.GetValue(0).ToString();

                }
            }
            catch
            {
                Console.WriteLine("Error SQL");
            }
        }
    }
}
