package cn.edu.gxnu.bean;

public class Permission implements Comparable<Permission>{

	private String permissionId;
	private String pId;
	private String name;
	private String icon;
	private String url;
	private String isParent;
	private String target;
	private String checked;
	private String open;
	
	public String getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIsParent() {
		return isParent;
	}
	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {

		this.open = open;
	}
	@Override
	public int compareTo(Permission o) {
		return this.getName().compareTo(o.getName());//按照权限名字
	}
}