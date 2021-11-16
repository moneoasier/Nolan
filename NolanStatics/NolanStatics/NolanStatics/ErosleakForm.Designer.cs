namespace NolanStatics
{
    partial class ErosleakForm
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
            this.erosleakDLL1 = new DLLs.ErosleakDLL();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // erosleakDLL1
            // 
            this.erosleakDLL1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.erosleakDLL1.Location = new System.Drawing.Point(-2, -1);
            this.erosleakDLL1.Name = "erosleakDLL1";
            this.erosleakDLL1.Size = new System.Drawing.Size(903, 414);
            this.erosleakDLL1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(253, 52);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(339, 37);
            this.label1.TabIndex = 2;
            this.label1.Text = "Erosleen Informazioa";
            // 
            // ErosleakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(930, 425);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.erosleakDLL1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "ErosleakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "ErosleakForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DLLs.ErosleakDLL erosleakDLL1;
        private System.Windows.Forms.Label label1;
    }
}