namespace NolanStatics
{
    partial class Salmentak
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
            this.sale_orderDLL1 = new DLLs.sale_orderDLL();
            this.SuspendLayout();
            // 
            // sale_orderDLL1
            // 
            this.sale_orderDLL1.Location = new System.Drawing.Point(38, 18);
            this.sale_orderDLL1.Name = "sale_orderDLL1";
            this.sale_orderDLL1.Size = new System.Drawing.Size(787, 495);
            this.sale_orderDLL1.TabIndex = 0;
            // 
            // Salmentak
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(870, 525);
            this.Controls.Add(this.sale_orderDLL1);
            this.Name = "Salmentak";
            this.Text = "Form2";
            this.ResumeLayout(false);

        }

        #endregion

        private DLLs.sale_orderDLL sale_orderDLL1;
    }
}