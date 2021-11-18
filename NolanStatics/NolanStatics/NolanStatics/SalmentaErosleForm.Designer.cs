namespace NolanStatics
{
    partial class SalmentaErosleForm
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
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Title title1 = new System.Windows.Forms.DataVisualization.Charting.Title();
            this.panel7 = new System.Windows.Forms.Panel();
            this.sal_eros = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.panel7.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.sal_eros)).BeginInit();
            this.SuspendLayout();
            // 
            // panel7
            // 
            this.panel7.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.panel7.Controls.Add(this.sal_eros);
            this.panel7.Location = new System.Drawing.Point(237, 20);
            this.panel7.Name = "panel7";
            this.panel7.Size = new System.Drawing.Size(456, 384);
            this.panel7.TabIndex = 11;
            // 
            // sal_eros
            // 
            this.sal_eros.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            chartArea1.AxisX.MajorGrid.LineColor = System.Drawing.Color.Transparent;
            chartArea1.AxisY.MajorGrid.LineColor = System.Drawing.Color.Transparent;
            chartArea1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            chartArea1.Name = "ChartArea1";
            this.sal_eros.ChartAreas.Add(chartArea1);
            legend1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            legend1.ForeColor = System.Drawing.Color.White;
            legend1.Name = "Legend1";
            this.sal_eros.Legends.Add(legend1);
            this.sal_eros.Location = new System.Drawing.Point(3, 3);
            this.sal_eros.Name = "sal_eros";
            this.sal_eros.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.SeaGreen;
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Pyramid;
            series1.Legend = "Legend1";
            series1.Name = "Series1";
            this.sal_eros.Series.Add(series1);
            this.sal_eros.Size = new System.Drawing.Size(450, 381);
            this.sal_eros.TabIndex = 4;
            title1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            title1.ForeColor = System.Drawing.Color.White;
            title1.Name = "Title1";
            title1.Text = "SALMENTA EROSLE BAKOITZEKO";
            this.sal_eros.Titles.Add(title1);
            // 
            // SalmentaErosleForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(930, 425);
            this.Controls.Add(this.panel7);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "SalmentaErosleForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SalmentaErosleForm";

            this.panel7.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.sal_eros)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel7;
        private System.Windows.Forms.DataVisualization.Charting.Chart sal_eros;
    }
}