using NolanStatics.NolanDataSetTableAdapters;
using System;
using System.Data.SqlClient;
using System.Linq;
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace NolanStatics
{
    public partial class Form1 : Form
    {
        

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
            // TODO: esta línea de código carga datos en la tabla 'nolanDataSet.res_users' Puede moverla o quitarla según sea necesario.
            // this.res_usersTableAdapter.Fill(this.nolanDataSet.res_users);

            countKat();
            countLang();
            countIrab();
            countErosle();
            countProd();
            countSalm();
            dataChart1();
            
            
        
            
        }
        public void dataChart1()
        {
            
           

            /*
            sale_orderTableAdapter sale_orderTableAdapter = new sale_orderTableAdapter();

            sale_orderTableAdapter.Fill(this.nolanDBDataSet.sale_order);

            sal_eros.DataSource = this.nolanDBDataSet.sale_order.GroupBy(b => b.partner_id).ToDictionary(g => g.Key, g => g.Count());

            sal_eros.Series[0].YValueMembers = "Value";
            sal_eros.Series[0].XValueMember = "Key";
            sal_eros.DataBind();
            
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
        
       /* public void selectWorkers()
        {
            conexionbd conexion = new conexionbd();
            conexion.abrir();

            string sententzia = "SELECT hr_employee.name, COUNT(sale_order.user_id) "+
                                 "FROM sale_order INNER JOIN "+
                                 "hr_employee ON sale_order.user_id = hr_employee.user_id "+
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

        }*/

        private void Panel1_Click(object sender, EventArgs e)
        {
            SalmentakForm salmentakForm = new SalmentakForm();
            salmentakForm.Show();
        }

        private void Panel4_Click(object sender, EventArgs e)
        {
            ProdKopForm prodKopForm = new ProdKopForm();
            prodKopForm.Show();
        }

        private void Panel3_Click(object sender, EventArgs e)
        {
            ErosleakForm erosleakForm = new ErosleakForm();
            erosleakForm.Show();
        }

        private void Panel2_Click(object sender, EventArgs e)
        {
            LangileakForm langileakForm = new LangileakForm();
            langileakForm.Show();
        }

        private void Panel8_Click(object sender, EventArgs e)
        {
            KategoriakForm kategoriakForm = new KategoriakForm();
            kategoriakForm.Show();
        }

        private void Panel5_Click(object sender, EventArgs e)
        {
            IrabaziakForm irabaziakForm = new IrabaziakForm();
            irabaziakForm.Show();
        }

        private void Button1_Click(object sender, EventArgs e)
        {
            SalmentaErosleForm salmentaErosleForm = new SalmentaErosleForm();
            salmentaErosleForm.Show();
        }

        private void Button2_Click(object sender, EventArgs e)
        {
            SalmentaLangileForm salmentaLangileForm = new SalmentaLangileForm();
            salmentaLangileForm.Show();
        }

        private void Button3_Click(object sender, EventArgs e)
        {
            TopSalmentak topSalmentak = new TopSalmentak();
            topSalmentak.Show();
        }

        private void Button4_Click(object sender, EventArgs e)
        {
            Topsaltzaileprecio topsaltzaileprecio = new Topsaltzaileprecio();
            topsaltzaileprecio.Show();
        }
    }
}
