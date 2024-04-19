import request from '@/utils/request'

// 查询项目类型列表
export function listProjectType(query) {
  return request({
    url: '/system/projectType/list',
    method: 'get',
    params: query
  })
}

// 查询项目类型详细
export function getProjectType(id) {
  return request({
    url: '/system/projectType/' + id,
    method: 'get'
  })
}

// 新增项目类型
export function addProjectType(data) {
  return request({
    url: '/system/projectType',
    method: 'post',
    data: data
  })
}

// 修改项目类型
export function updateProjectType(data) {
  return request({
    url: '/system/projectType',
    method: 'put',
    data: data
  })
}

// 删除项目类型
export function delProjectType(id) {
  return request({
    url: '/system/projectType/' + id,
    method: 'delete'
  })
}
