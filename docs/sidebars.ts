import type {SidebarsConfig} from '@docusaurus/plugin-content-docs';

const sidebars: SidebarsConfig = {
  docsSidebar: [
    {
      type: 'category',
      label: 'Docs',
      collapsible: false,
      items: [
        'intro',
        'setup',
        'how_to_use',
      ],
    },
  ],
};

export default sidebars;
