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
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.numericUpDown1 = new System.Windows.Forms.NumericUpDown();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.saleorderline1BindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nolanDataSetBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nolanDataSet = new NolanStatics.NolanDataSet();
            this.sale_order_line1TableAdapter1 = new NolanStatics.NolanDataSetTableAdapters.sale_order_line1TableAdapter();
            this.label1 = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.numericUpDown1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderline1BindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSetBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // numericUpDown1
            // 
            this.numericUpDown1.Location = new System.Drawing.Point(150, 217);
            this.numericUpDown1.Name = "numericUpDown1";
            this.numericUpDown1.Size = new System.Drawing.Size(120, 20);
            this.numericUpDown1.TabIndex = 0;
            this.numericUpDown1.ValueChanged += new System.EventHandler(this.NumericUpDown1_ValueChanged);
            // 
            // chart1
            // 
            this.chart1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            chartArea1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            this.chart1.DataSource = this.saleorderline1BindingSource;
            legend1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            legend1.ForeColor = System.Drawing.Color.White;
            legend1.Name = "Legend1";
            this.chart1.Legends.Add(legend1);
            this.chart1.Location = new System.Drawing.Point(315, 107);
            this.chart1.Name = "chart1";
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Pie;
            series1.LabelForeColor = System.Drawing.Color.Transparent;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.chart1.Series.Add(series1);
            this.chart1.Size = new System.Drawing.Size(742, 429);
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
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(308, 23);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(462, 37);
            this.label1.TabIndex = 4;
            this.label1.Text = "Gehien saldutako produktuak";
            // 
            // TopSalmentak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(1150, 586);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.chart1);
            this.Controls.Add(this.numericUpDown1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "TopSalmentak";
            this.Text = "TopSalmentak";
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
    }
}