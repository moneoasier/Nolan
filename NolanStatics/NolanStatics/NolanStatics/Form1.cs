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

        private void pictureBox1_Click(object sender, EventArgs e)
        {
            SalmentakForm salmentakForm = new SalmentakForm();
            salmentakForm.Show();
        }

        private void pictureBox2_Click(object sender, EventArgs e)
        {
            LangileakForm langileakForm = new LangileakForm();
            langileakForm.Show();
        }

        private void pictureBox4_Click(object sender, EventArgs e)
        {
            ProdKopForm prodKopForm = new ProdKopForm();
            prodKopForm.Show();
        }

        private void pictureBox6_Click(object sender, EventArgs e)
        {
            KategoriakForm kategoriakForm = new KategoriakForm();
            kategoriakForm.Show();
        }

        private void pictureBox3_Click(object sender, EventArgs e)
        {
            ErosleakForm erosleakForm = new ErosleakForm();
            erosleakForm.Show();
        }

        private void pictureBox5_Click(object sender, EventArgs e)
        {
            IrabaziakForm irabaziakForm = new IrabaziakForm();
            irabaziakForm.Show();
        }
    }
}
