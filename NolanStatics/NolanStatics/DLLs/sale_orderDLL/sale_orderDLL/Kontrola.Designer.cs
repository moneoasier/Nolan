namespace sale_orderDLL
{
    partial class Kontrola
    {
        /// <summary> 
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary> 
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de componentes

        /// <summary> 
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.idDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.amounttaxDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.amounttotalDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.dateorderDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.nameDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.procurementgroupidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.stateDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.partneridDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.createuidDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.useridDataGridViewTextBoxColumn = new System.Windows.Forms.DataGridViewTextBoxColumn();
            this.saleorderBindingSource = new System.Windows.Forms.BindingSource(this.components);
            this.nolanDataSet = new sale_orderDLL.NolanDataSet();
            this.sale_orderTableAdapter = new sale_orderDLL.NolanDataSetTableAdapters.sale_orderTableAdapter();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderBindingSource)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).BeginInit();
            this.SuspendLayout();
            // 
            // dataGridView1
            // 
            this.dataGridView1.AutoGenerateColumns = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Columns.AddRange(new System.Windows.Forms.DataGridViewColumn[] {
            this.idDataGridViewTextBoxColumn,
            this.amounttaxDataGridViewTextBoxColumn,
            this.amounttotalDataGridViewTextBoxColumn,
            this.dateorderDataGridViewTextBoxColumn,
            this.nameDataGridViewTextBoxColumn,
            this.procurementgroupidDataGridViewTextBoxColumn,
            this.stateDataGridViewTextBoxColumn,
            this.partneridDataGridViewTextBoxColumn,
            this.createuidDataGridViewTextBoxColumn,
            this.useridDataGridViewTextBoxColumn});
            this.dataGridView1.DataSource = this.saleorderBindingSource;
            this.dataGridView1.Location = new System.Drawing.Point(33, 135);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.Size = new System.Drawing.Size(676, 150);
            this.dataGridView1.TabIndex = 0;
            // 
            // idDataGridViewTextBoxColumn
            // 
            this.idDataGridViewTextBoxColumn.DataPropertyName = "id";
            this.idDataGridViewTextBoxColumn.HeaderText = "id";
            this.idDataGridViewTextBoxColumn.Name = "idDataGridViewTextBoxColumn";
            // 
            // amounttaxDataGridViewTextBoxColumn
            // 
            this.amounttaxDataGridViewTextBoxColumn.DataPropertyName = "amount_tax";
            this.amounttaxDataGridViewTextBoxColumn.HeaderText = "amount_tax";
            this.amounttaxDataGridViewTextBoxColumn.Name = "amounttaxDataGridViewTextBoxColumn";
            // 
            // amounttotalDataGridViewTextBoxColumn
            // 
            this.amounttotalDataGridViewTextBoxColumn.DataPropertyName = "amount_total";
            this.amounttotalDataGridViewTextBoxColumn.HeaderText = "amount_total";
            this.amounttotalDataGridViewTextBoxColumn.Name = "amounttotalDataGridViewTextBoxColumn";
            // 
            // dateorderDataGridViewTextBoxColumn
            // 
            this.dateorderDataGridViewTextBoxColumn.DataPropertyName = "date_order";
            this.dateorderDataGridViewTextBoxColumn.HeaderText = "date_order";
            this.dateorderDataGridViewTextBoxColumn.Name = "dateorderDataGridViewTextBoxColumn";
            // 
            // nameDataGridViewTextBoxColumn
            // 
            this.nameDataGridViewTextBoxColumn.DataPropertyName = "name";
            this.nameDataGridViewTextBoxColumn.HeaderText = "name";
            this.nameDataGridViewTextBoxColumn.Name = "nameDataGridViewTextBoxColumn";
            // 
            // procurementgroupidDataGridViewTextBoxColumn
            // 
            this.procurementgroupidDataGridViewTextBoxColumn.DataPropertyName = "procurement_group_id";
            this.procurementgroupidDataGridViewTextBoxColumn.HeaderText = "procurement_group_id";
            this.procurementgroupidDataGridViewTextBoxColumn.Name = "procurementgroupidDataGridViewTextBoxColumn";
            // 
            // stateDataGridViewTextBoxColumn
            // 
            this.stateDataGridViewTextBoxColumn.DataPropertyName = "state";
            this.stateDataGridViewTextBoxColumn.HeaderText = "state";
            this.stateDataGridViewTextBoxColumn.Name = "stateDataGridViewTextBoxColumn";
            // 
            // partneridDataGridViewTextBoxColumn
            // 
            this.partneridDataGridViewTextBoxColumn.DataPropertyName = "partner_id";
            this.partneridDataGridViewTextBoxColumn.HeaderText = "partner_id";
            this.partneridDataGridViewTextBoxColumn.Name = "partneridDataGridViewTextBoxColumn";
            // 
            // createuidDataGridViewTextBoxColumn
            // 
            this.createuidDataGridViewTextBoxColumn.DataPropertyName = "create_uid";
            this.createuidDataGridViewTextBoxColumn.HeaderText = "create_uid";
            this.createuidDataGridViewTextBoxColumn.Name = "createuidDataGridViewTextBoxColumn";
            // 
            // useridDataGridViewTextBoxColumn
            // 
            this.useridDataGridViewTextBoxColumn.DataPropertyName = "user_id";
            this.useridDataGridViewTextBoxColumn.HeaderText = "user_id";
            this.useridDataGridViewTextBoxColumn.Name = "useridDataGridViewTextBoxColumn";
            // 
            // saleorderBindingSource
            // 
            this.saleorderBindingSource.DataMember = "sale_order";
            this.saleorderBindingSource.DataSource = this.nolanDataSet;
            // 
            // nolanDataSet
            // 
            this.nolanDataSet.DataSetName = "NolanDataSet";
            this.nolanDataSet.SchemaSerializationMode = System.Data.SchemaSerializationMode.IncludeSchema;
            // 
            // sale_orderTableAdapter
            // 
            this.sale_orderTableAdapter.ClearBeforeFill = true;
            // 
            // Kontrola
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.dataGridView1);
            this.Name = "Kontrola";
            this.Size = new System.Drawing.Size(844, 512);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.saleorderBindingSource)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.nolanDataSet)).EndInit();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.DataGridViewTextBoxColumn idDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn amounttaxDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn amounttotalDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn dateorderDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn nameDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn procurementgroupidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn stateDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn partneridDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn createuidDataGridViewTextBoxColumn;
        private System.Windows.Forms.DataGridViewTextBoxColumn useridDataGridViewTextBoxColumn;
        private System.Windows.Forms.BindingSource saleorderBindingSource;
        private NolanDataSet nolanDataSet;
        private NolanDataSetTableAdapters.sale_orderTableAdapter sale_orderTableAdapter;
    }
}
