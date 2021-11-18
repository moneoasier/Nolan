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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(SalmentaLangileForm));
            this.sal_lan = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.label1 = new System.Windows.Forms.Label();
            this.panel1 = new System.Windows.Forms.Panel();
            ((System.ComponentModel.ISupportInitialize)(this.sal_lan)).BeginInit();
            this.SuspendLayout();
            // 
            // sal_lan
            // 
            this.sal_lan.BackColor = System.Drawing.Color.Transparent;
            chartArea1.Area3DStyle.Enable3D = true;
            chartArea1.Area3DStyle.IsRightAngleAxes = false;
            chartArea1.BackColor = System.Drawing.Color.Transparent;
            chartArea1.Name = "ChartArea1";
            chartArea1.ShadowColor = System.Drawing.Color.Transparent;
            this.sal_lan.ChartAreas.Add(chartArea1);
            legend1.BackColor = System.Drawing.Color.Transparent;
            legend1.ForeColor = System.Drawing.Color.White;
            legend1.Name = "Legend1";
            legend1.Title = "Langileak:";
            legend1.TitleAlignment = System.Drawing.StringAlignment.Near;
            legend1.TitleForeColor = System.Drawing.Color.White;
            this.sal_lan.Legends.Add(legend1);
            this.sal_lan.Location = new System.Drawing.Point(272, 216);
            this.sal_lan.Name = "sal_lan";
            this.sal_lan.Size = new System.Drawing.Size(444, 378);
            this.sal_lan.TabIndex = 0;
            this.sal_lan.Text = "chart1";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.BackColor = System.Drawing.Color.Transparent;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 21.75F, System.Drawing.FontStyle.Italic);
            this.label1.ForeColor = System.Drawing.SystemColors.ControlLightLight;
            this.label1.Location = new System.Drawing.Point(88, 139);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(391, 33);
            this.label1.TabIndex = 1;
            this.label1.Text = "Salmenta Langile Bakoitzeko";
            // 
            // panel1
            // 
            this.panel1.BackColor = System.Drawing.Color.Transparent;
            this.panel1.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("panel1.BackgroundImage")));
            this.panel1.Location = new System.Drawing.Point(948, 63);
            this.panel1.Name = "panel1";
            this.panel1.Size = new System.Drawing.Size(54, 50);
            this.panel1.TabIndex = 3;
            this.panel1.Click += new System.EventHandler(this.panel1_Click);
            // 
            // SalmentaLangileForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("$this.BackgroundImage")));
            this.ClientSize = new System.Drawing.Size(1066, 637);
            this.Controls.Add(this.panel1);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.sal_lan);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.None;
            this.Name = "SalmentaLangileForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "SalmentaLangileForm";
            this.TopMost = true;
            ((System.ComponentModel.ISupportInitialize)(this.sal_lan)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart sal_lan;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Panel panel1;
    }
}