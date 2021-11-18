namespace NolanStatics
{
    partial class TopSalmentak
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea3 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend3 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series3 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(TopSalmentak));
            this.numericUpDown1 = new System.Windows.Forms.NumericUpDown();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.saleorderline1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nolanDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nolanDataSet = new NolanStatics.NolanDataSet();
            this.sale_order_line1TableAdapter1 = new NolanStatics.NolanDataSetTableAdapters.sale_order_line1TableAdapter();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            this.label2 = new System.Windows.Forms.Label();
            this.label3Zenb = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderline1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.numericUpDown1.Location = new System.Drawing.Point(201, 206);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(42, 31);
            this.numericUpDown1.TabIndex = 0;
            this.numericUpDown1.ValueChanged += new System.EventHandler(this.NumericUpDown1_ValueChanged);
            // 
            // chart1
            // 
            this.chart1.BackColor = System.Drawing.Color.Transparent;
            chartArea3.BackColor = System.Drawing.Color.Transparent;
            chartArea3.Name = "ChartArea1";
            chartArea3.ShadowColor = System.Drawing.Color.Transparent;
            this.chart1.ChartAreas.Add(chartArea3);
            this.chart1.DataSource = this.saleorderline1BindingSource;
            legend3.BackColor = System.Drawing.Color.Transparent;
            legend3.ForeColor = System.Drawing.Color.White;
            legend3.Name = "Legend1";
            legend3.ShadowColor = System.Drawing.Color.Transparent;
            this.chart1.Legends.Add(legend3);
            this.chart1.Location = new System.Drawing.Point(276, 161);
            this.chart1.Name = "chart1";
            series3.ChartArea = "ChartArea1";
            series3.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Pie;
            series3.LabelForeColor = System.Drawing.Color.Transparent;
            series3.Legend = "Legend1";
            series3.Name = "Series1";
            this.chart1.Series.Add(series3);
            this.chart1.Size = new System.Drawing.Size(742, 403);
            this.chart1.TabIndex = 1;
            this.chart1.Text = "chart1";
            // 
            // saleorderline1BindingSource
            // 
            this.saleorderline1BindingSource.DataMember = "sale_order_line1";
            this.saleorderline1BindingSource.DataSource = this.nolanDataSetBindingSource;
            // 
            // nolanDataSetBindingSource
            // 
            this.nolanDataSetBindingSource.DataSource = this.nolanDataSet;
            this.nolanDataSetBindingSource.Position = 0;
            // 
            // nolanDataSet
            // 
            this.nolanDataSet.DataSetName = "NolanDataSet";
            this.nolanDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sale_order_line1TableAdapter1
            // 
            this.sale_order_line1TableAdapter1.ClearBeforeFill = true;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(180, 125);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(394, 33);
            this.label1.TabIndex = 4;
            this.label1.Text = "Gehien saldutako produktuak";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel1.BackgroundImage")));
            this.panel1.Location = new System.Drawing.Point(992, 68);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(54, 50);
            this.panel1.TabIndex = 5;
            this.panel1.Click += new System.EventHandler(this.panel1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.BackColor = System.Drawing.Color.Transparent;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.White;
            this.label2.Location = new System.Drawing.Point(72, 125);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(65, 33);
            this.label2.TabIndex = 6;
            this.label2.Text = "Top";
            // 
            // label3Zenb
            // 
            this.label3Zenb.AutoSize = true;
            this.label3Zenb.BackColor = System.Drawing.Color.Transparent;
            this.label3Zenb.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3Zenb.ForeColor = System.Drawing.Color.White;
            this.label3Zenb.Location = new System.Drawing.Point(134, 125);
            this.label3Zenb.Name = "label3Zenb";
            this.label3Zenb.Size = new System.Drawing.Size(31, 33);
            this.label3Zenb.TabIndex = 7;
            this.label3Zenb.Text = "0";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.BackColor = System.Drawing.Color.Transparent;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 15.75F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.ForeColor = System.Drawing.Color.White;
            this.label3.Location = new System.Drawing.Point(88, 212);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(107, 25);
            this.label3.TabIndex = 8;
            this.label3.Text = "Zenbakia:";
            // 
            // TopSalmentak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1127, 625);
            this.ControlBox = false;
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label3Zenb);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.chart1);
            this.Controls.Add(this.numericUpDown1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "TopSalmentak";
            this.Text = "TopSalmentak";
            this.TopMost = true;
            this.Load += new System.EventHandler(this.TopSalmentak_Load);
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderline1BindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSetBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.NumericUpDown numericUpDown1;
        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
        private System.Windows.Forms.BindingSource nolanDataSetBindingSource;
        private NolanDataSet nolanDataSet;
        private System.Windows.Forms.BindingSource saleorderline1BindingSource;
        private NolanDataSetTableAdapters.sale_order_line1TableAdapter sale_order_line1TableAdapter1;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3Zenb;
        private System.Windows.Forms.Label label3;
    }
}