package com.baitaplon.controller.admin.form;

import java.util.List;

public class RequestDelete {
		private List<String> ids;

		public RequestDelete(List<String> ids) {
			super();
			this.ids = ids;
		}

		public List<String> getIds() {
			return ids;
		}

		public void setIds(List<String> ids) {
			this.ids = ids;
		}

		public RequestDelete() {
			super();
			// TODO Auto-generated constructor stub
		}
		
}
