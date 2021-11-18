namespace NolanStatics
{
    partial class IrabaziakForm
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
            this.irabaziakDLL1 = new DLLs.IrabaziakDLL();
            this.label1 = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // irabaziakDLL1
            // 
            this.irabaziakDLL1.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.irabaziakDLL1.Location = new System.Drawing.Point(12, -55);
            this.irabaziakDLL1.Name = "irabaziakDLL1";
            this.irabaziakDLL1.Size = new System.Drawing.Size(958, 506);
            this.irabaziakDLL1.TabIndex = 0;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Sans Serif", 24F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.White;
            this.label1.Location = new System.Drawing.Point(311, 29);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(270, 37);
            this.label1.TabIndex = 3;
            this.label1.Text = "Top 5 salmentak";
            // 
            // IrabaziakForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.ClientSize = new System.Drawing.Size(930, 425);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.irabaziakDLL1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "IrabaziakForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "IrabaziakForm";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private DLLs.IrabaziakDLL irabaziakDLL1;
        private System.Windows.Forms.Label label1;
    }
}