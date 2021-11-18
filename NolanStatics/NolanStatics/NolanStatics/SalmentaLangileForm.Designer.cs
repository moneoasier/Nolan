namespace NolanStatics
{
    partial class SalmentaLangileForm
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
            System.Windows.Forms.DataVisualization.Charting.Title title1 = new System.Windows.Forms.DataVisualization.Charting.Title();
            this.panel6 = new System.Windows.Forms.Panel();
            this.sal_lan = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.panel6.SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(this.sal_lan)).BeginInit();
            this.SuspendLayout();
            // 
            // panel6
            // 
            this.panel6.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.panel6.Controls.Add(this.sal_lan);
            this.panel6.Location = new System.Drawing.Point(178, 33);
            this.panel6.Name = "panel6";
            this.panel6.Size = new System.Drawing.Size(444, 384);
            this.panel6.TabIndex = 10;
            // 
            // sal_lan
            // 
            this.sal_lan.BackColor = System.Drawing.Color.DimGray;
            chartArea1.Area3DStyle.Enable3D = true;
            chartArea1.Area3DStyle.IsRightAngleAxes = false;
            chartArea1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            chartArea1.Name = "ChartArea1";
            this.sal_lan.ChartAreas.Add(chartArea1);
            legend1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            legend1.ForeColor = System.Drawing.Color.White;
            legend1.Name = "Legend1";
            legend1.Title = "Langileak:";
            legend1.TitleAlignment = System.Drawing.StringAlignment.Near;
            legend1.TitleForeColor = System.Drawing.Color.White;
            this.sal_lan.Legends.Add(legend1);
            this.sal_lan.Location = new System.Drawing.Point(0, 3);
            this.sal_lan.Name = "sal_lan";
            this.sal_lan.Size = new System.Drawing.Size(444, 378);
            this.sal_lan.TabIndex = 0;
            this.sal_lan.Text = "chart1";
            title1.Font = new System.Drawing.Font("Microsoft Sans Serif", 12F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            title1.ForeColor = System.Drawing.Color.White;
            title1.Name = "Title1";
            title1.Text = "SALMENTA LANGILE BAKOITZEKO";
            this.sal_lan.Titles.Add(title1);
            // 
            // SalmentaLangileForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.panel6);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "SalmentaLangileForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SalmentaLangileForm";
            this.panel6.ResumeLayout(false);
            ((System.ComponentModel.ISupportInitialize)(this.sal_lan)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Panel panel6;
        private System.Windows.Forms.DataVisualization.Charting.Chart sal_lan;
    }
}